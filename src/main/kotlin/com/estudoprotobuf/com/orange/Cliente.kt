package com.estudoprotobuf.com.orange

import io.grpc.ManagedChannelBuilder
import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

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
                .build())
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)

    println(response)
}

