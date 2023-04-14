package br.imd.ufrn.segurancaonlinebackend.model;

import java.util.HashSet;
import java.util.Set;

public class MessageFilter {

    public static final Set<String> forbiddenWords;

    static {
        forbiddenWords = new HashSet<>();
        forbiddenWords.add("seu lixo");
        forbiddenWords.add("horrível");
        forbiddenWords.add("delinquente");
    }

}
