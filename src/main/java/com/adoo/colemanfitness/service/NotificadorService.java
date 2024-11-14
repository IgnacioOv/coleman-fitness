package com.adoo.colemanfitness.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public abstract class NotificadorService {
    public static void sendNotificacion(String message){
        System.out.println(message);
    }
}
