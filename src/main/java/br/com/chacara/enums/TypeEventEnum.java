package br.com.chacara.enums;

public enum TypeEventEnum {

    ANIVERSARIO("A"), CASAMENTO("S"), CHURRASCO("C"), CHADEBEBE("B"), RETIRO("R"), FAMILIAR("F");

    public String tpEvento;

    TypeEventEnum(String evento) {
        tpEvento = evento;
    }
}
