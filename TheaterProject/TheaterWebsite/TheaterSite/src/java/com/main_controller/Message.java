/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main_controller;

/**
 *
 * @author Asif Ali
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Message {
   private String message = "Hello World! how are you";
            
   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }
}