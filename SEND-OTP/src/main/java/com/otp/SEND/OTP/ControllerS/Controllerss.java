package com.otp.SEND.OTP.ControllerS;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class Controllerss {
	Map<String, String> otpmap = new HashMap();

	@GetMapping("/sendSms/{tomoblieNO}")

	public ResponseEntity sendSMS(@PathVariable("tomoblieNO") String tomoblieNO) {

		Twilio.init("AC7e474bebc9051878175bc9b30248dd94", "c06774ecda565eea593047396551770b");

		Message.creator(new PhoneNumber(tomoblieNO), new PhoneNumber("+15863004325"),genratotp(tomoblieNO)).create();

		return new ResponseEntity("message Sent Succssfull", HttpStatus.OK);
	}
		
	

	private String genratotp(String moblieNo) {

		Random random = new Random();

		String otp = String.valueOf(random.nextInt(900000) + 100000);

		otpmap.put(moblieNo, otp);
		return otp;
	}

	@GetMapping("validotp/{mNo}/{otp}")

	public ResponseEntity validotp(@PathVariable("mNo") String mNo, @PathVariable("otp") String otp) {

		if (otpmap.containsKey(mNo)) {

			if (otp.equals(otpmap.get(mNo))) {

				return new ResponseEntity("otp validte succssfull", HttpStatus.OK);

			}
		}
		return new ResponseEntity("invalidte Otp", HttpStatus.BAD_REQUEST);

	}
}