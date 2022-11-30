package com.example.design_pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.design_pattern.Dependencyinjectionpattern.Laptop

class MainActivity : AppCompatActivity() {

    private val tvView: TextView by lazy { findViewById<TextView>(R.id.tvView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //hôm nay sẽ học về Singleton pattern trong Creational pattern
        // - nó có thể tạo ra một instance được tạo ra trong một ứng dụng
        //      Singleton pattern thường được sử dụng trong các trường hợp: logging, database creation, thread pool
        //      nó được tạo thông qua object class và companion object class
        //xem chi tiet trong NoteAppRoomDbMVVMViewModel

        //Dependency injection pattern

        val instance = Laptop.Builder()
            .setRam("b")
            .setName("a")
            .build()
        // Nếu bạn đã sử dụng Kotlin được một thời gian,
        // bạn đã biết các scope functions như
        // let, also, apply , v.v. - hãy xem qua lợi ích của việc sử dụng chúng.
        //
        //Về cơ bản, các hàm này làm điều tương tự nhau
        // - thực thi một khối mã trên một đối tượng.
        // Điều khác biệt là cách đối tượng này trở nên khả dụng
        // bên trong khối và kết quả của toàn bộ biểu thức là gì.
        // Hãy cùng đi qua một vài trong số chúng


        //let là một scope functions trong đó các biến
        // khai báo bên trong biểu thức không thể được
        // sử dụng ở ngoài . let lấy đối tượng mà nó
        // được gọi làm tham số và trả về kết quả của
        // biểu thức lambda. Hãy xem cách sử dụng của nó:
//        Laptop("aa", "bb").let {
//           tvView.text = it.name
//        }
        Laptop("8GB", "HP").run {
            println(this.ram)
        }
        tvView.apply {
            text ="Scope funs apply"
            hint = "hide this from apply"
        }
        val laptop = Laptop()
        with(laptop){
            name = "abcxyz"
            tvView.apply {
                text ="huyuyuy"
            }
        }

    }
}