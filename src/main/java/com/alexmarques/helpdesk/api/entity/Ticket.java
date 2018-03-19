package com.alexmarques.helpdesk.api.entity;

import java.awt.List;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alexmarques.helpdesk.api.enums.PriorityEnum;
import com.alexmarques.helpdesk.api.enums.StatusEnum;

@Document
public class Ticket {

	@Id
	private String id;
	
	@DBRef(lazy = true)
	private User user;
	
	private Date date;
	
	private String title;
	
	private Integer number;
	
	private StatusEnum status;
	
	private PriorityEnum priority;
	
	@DBRef(lazy = true)  // Aqui informamos que o campo é chave extrangeira
	private User assignedUser;
	
	private String description;
	
	private String image;
	
	@Transient   // Aqui informamos que o campo não será criado no banco de dados
	private List changes;
	
	
}
