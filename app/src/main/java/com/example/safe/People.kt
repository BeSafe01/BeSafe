package com.example.safe

class People {

    var name : String = ""
    var email : String =""
    var password : String = ""
    var cpf : String = ""
    var rg : String = ""
    var phone : String = ""
    var phoneEmergency : String = ""
    var dateBirth: String = ""

    constructor(name: String,email: String,password: String,cpf: String,rg: String,phone: String,phoneEmergency: String,dateBirth: String) {
        this.name = name
        this.email = email
        this.password = password
        this.cpf = cpf
        this.rg = rg
        this.phone = phone
        this.phoneEmergency = phoneEmergency
        this.dateBirth = dateBirth
    }

    fun PeopleClass(){}
}