
package com.project.Frontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.Backend.DAO.UserDAO;
import com.project.Backend.Model.Address;
import com.project.Backend.Model.Cart;
import com.project.Backend.Model.User;
import com.project.Frontend.Model.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {

		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}

	public String validateUser(User user, MessageContext error) {

		String transitionValue = "success";
		// checking for confirmpassword

		if (!(user.getPassword()).equals(user.getConfirmPassword())) {

			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("passsword does not match").build());

			transitionValue = "failure";
		}

		// checking for unique or not existing email

		if (userDAO.getByEmail(user.getEmail()) != null) {

			error.addMessage(
					new MessageBuilder().error().source("email").defaultText("this email is alredy exist").build());

			transitionValue = "failure";

		}

		return transitionValue;

	}

	public String saveAll(RegisterModel model) {
		String transitionValue = "success";

		// feath the User
		User user = model.getUser();
		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}

		// encode the password

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// save User
		userDAO.addUser(user);
		// get the address
		Address billing = model.getBilling();
		billing.setUserId(user.getId());

		billing.setBilling(true);

		userDAO.addAddresss(billing);

		return transitionValue;
	}
}
