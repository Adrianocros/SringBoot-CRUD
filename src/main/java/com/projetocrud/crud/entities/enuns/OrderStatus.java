package com.projetocrud.crud.entities.enuns;

import org.aspectj.weaver.ast.Or;

public enum OrderStatus {
    //(Valores atribuidos para orden)
    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    //converte valor numerico da enun
    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo de status da ordem invalido");
    }

}
