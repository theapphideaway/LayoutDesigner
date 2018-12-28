package com.example.ianschoenrock.layoutdesigner

import android.content.Context
import android.hardware.Sensor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.hardware.SensorManager
import android.os.Environment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.exists
import android.os.Environment.getExternalStorageDirectory
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.nio.file.Files.isDirectory
import java.nio.file.Files.exists


private val filename = "CashMoney.txt"
var stringBuffer: StringBuffer? = null
var fileToReadAndWrite: File? = null

class MainActivity : AppCompatActivity() {


    private var sensorMan: SensorManager? = null
    private var accelerometer: Sensor? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            if (isExternalStorageWritable()) {
                if (filesDir.exists() ) {
                    if (isFileWritable(filesDir)) {
                        writeToFile(getFilename())
                    } else {
                        Toast.makeText(this@MainActivity, "Not Writable dir", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "No directory", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Storage not writable.", Toast.LENGTH_LONG).show()


        }


        ///storage/emulated/0/myfile

    }


    fun isExternalStorageWritable(): Boolean {
        val state = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED == state) {
            true
        } else false
    }


    fun getDocumentStoragePath(): File {
        // Get the directory for the user's public documents directory.
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!path.mkdirs()) {
            path.mkdirs()
        }
        return path
    }


    fun getFilename(): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), filename)
        return fileToReadAndWrite as File
    }

    fun isFileWritable(file: File): Boolean {
        return if (!file.canWrite()) {
            file.setWritable(true)
        } else file.canWrite()
    }


    fun writeToFile(textfile: File) {
        try {

            val fos = FileOutputStream(textfile)
            fos.write("Hello World I'm writing to a file".toByteArray())
            fos.close()
            Toast.makeText(this@MainActivity, "Finish writing...", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_LONG).show()
        } finally {

        }
    }


}
