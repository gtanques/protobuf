package com.estudoprotobuf.com.orange

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(args: Array<String>) {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Naruto Uzumaki")
        .setCpf("111.111.121-33")
        .setSalario(2000.0)
        .setAtivo(true)
        .setCargo(Cargo.QA) // Não vai mostrar quando for 0 o enum, pois o item 0 é o valor default então vai economizar bytes na rede
        .addEnderecos(
            FuncionarioRequest.Endereco.newBuilder()
                .setLogradouro("Rua das Laranjeiras")
                .setCep("00000-000")
                .setComplemento("Casa")
                .build()
        )
        .build()

    // escrevemos objeto
    println(request)

    request.writeTo(FileOutputStream("funcionario-request.bin"))

    // lemos objeto
    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

	request2.setCargo(Cargo.GERENTE)
		.build()

    println(request)
}

