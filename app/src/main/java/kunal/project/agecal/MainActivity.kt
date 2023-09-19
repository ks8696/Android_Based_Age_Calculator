package kunal.project.agecal

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var selected:TextView?=null
    var hours:TextView?=null
    var minute:TextView?=null
    var second:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button)
        selected=findViewById(R.id.selectedDate)
        hours=findViewById(R.id.hour)
        minute=findViewById(R.id.minutes)
        second=findViewById(R.id.second)
        button.setOnClickListener {
            date()

        }
    }

    private fun date(){
        val calender=Calendar.getInstance()
       val year=calender.get(Calendar.YEAR)
       val month=calender.get(Calendar.MONTH)
        val date=calender.get(Calendar.DAY_OF_MONTH)
        var res:Long=0
        var res1:Long=0
        var res2:Long=0
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { _, year, month, dayofMonth ->

            var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            var date = sdf.parse("$dayofMonth/${month + 1}/$year")
            var x = sdf.parse(sdf.format(System.currentTimeMillis()))

            date?.let {
                var datetillselect = date.time / 3600000
                var datetillnow = x.time / 3600000
                res = datetillnow - datetillselect


                var datetillselect1 = date.time / 60000
                var datetillnow1 = x.time / 60000
                res1 = datetillnow1 - datetillselect1


                var datetillselect2 = date.time / 1000
                var datetillnow2 = x.time / 1000
                res2 = datetillnow2 - datetillselect2

            }
                if (res > 0) {
                    selected?.text = "$dayofMonth/${month + 1}/$year"
                    hours?.text = "$res"
                    minute?.text = "$res1"
                    second?.text = "$res2"
                }
            else
            Toast.makeText(this, "You are yet to be born KING!!", Toast.LENGTH_SHORT).show()
    },year,month,date).show()
    }
}