package com.asantana.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.asantana.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obg);

	void sendMail(SimpleMailMessage msg);

}
