package com.estudoprotobuf.com.orange

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.estudoprotobuf.com.orange")
		.start()
}

