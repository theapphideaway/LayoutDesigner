package com.example.ianschoenrock.layoutdesigner

import android.Manifest
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
import android.Manifest.permission
import android.Manifest.permission.SEND_SMS
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log


private val filename = "DangerousVersion3.txt"
var stringBuffer: StringBuffer? = null
var fileToReadAndWrite: File? = null

class MainActivity : AppCompatActivity() {


    private var sensorMan: SensorManager? = null
    private var accelerometer: Sensor? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val PERMISSION_REQUEST_CODE = 1

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                Log.d("permission", "permission denied to SEND_SMS - requesting it")
                val permissions = arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE)

                requestPermissions(permissions, PERMISSION_REQUEST_CODE)

            }
        }



        button.setOnClickListener {
            if (isExternalStorageWritable()) {
                if (filesDir.exists()) {
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
        }



        ///storage/emulated/0/myfile

    }


    private fun isExternalStorageWritable(): Boolean {
        val state = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == state
    }


    private fun getDocumentStoragePath(): File {
        // Get the directory for the user's public documents directory.
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!path.mkdirs()) {
            path.mkdirs()
        }
        return path
    }


    private fun getFilename(): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), filename)
        return fileToReadAndWrite as File
    }

    private fun isFileWritable(file: File): Boolean {
        return if (!file.canWrite()) {
            file.setWritable(true)
        } else file.canWrite()
    }


    private fun writeToFile(textFile: File) {
        try {

            val fos = FileOutputStream(textFile)
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
