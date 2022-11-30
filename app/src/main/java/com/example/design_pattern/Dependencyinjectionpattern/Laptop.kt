package com.example.design_pattern.Dependencyinjectionpattern

 data class Laptop(var ram: String ="",var name: String ="") {
    class Builder {
        var ram: String = "2GB"
            private set
        var name: String = "HP"
            private set
        fun setRam(ram : String) = apply { this.ram = ram }
        fun setName(name : String) = apply { this.name = name }

        fun build(): Laptop = Laptop(ram, name)
    }

}