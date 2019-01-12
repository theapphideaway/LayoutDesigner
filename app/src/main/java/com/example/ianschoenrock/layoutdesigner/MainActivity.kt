package com.example.ianschoenrock.layoutdesigner


import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.WebViewClient
import android.widget.Toast
import java.io.*


class MainActivity : AppCompatActivity() {

//    var fileToReadAndWrite: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val PERMISSION_REQUEST_CODE = 1
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permissions, PERMISSION_REQUEST_CODE)
            }
        }

        var filename = "Welcome.txt"
        // create a File object for the parent directory
        val wallpaperDirectory = File("/sdcard/Memesboiii/")
        // have the object build the directory structure, if needed.
        wallpaperDirectory.mkdirs()
        // create a File object for the output file
        val outputFile = File(wallpaperDirectory, filename)
        // now attach the OutputStream to the file object, instead of a String representation
        try {
            val fos = FileOutputStream(outputFile)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

//        if (isExternalStorageWritable()) {
//            if (filesDir.exists()) {
//                if (isFileWritable(filesDir)) {
//                    writeToFile("This is a message from File One", getFilename("messageOne.txt"))
//                    writeToFile("Hey guys, File Two Here", getFilename("messageTow.txt"))
//                    writeToFile("So You already know its file three", getFilename("messageThree.txt"))
//                    writeToFile("BRUH$$$$$$4", getFilename("messageFour.txt"))
//                    writeToFile("I really dont have anything clever for File Five", getFilename("messageFive.txt"))
//                    writeToFile("A little something for file six", getFilename("messageSix.txt"))
//                    writeToFile("I wrote way too many files, I'm at file seven!", getFilename("messageSeven.txt"))
//                    writeToFile("Finishing up here with file 8", getFilename("messageEight.txt"))
//
//                } else {
//                    Toast.makeText(this, "Not Writable dir", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "No directory", Toast.LENGTH_LONG).show()
//            }
//        } else {
//            Toast.makeText(this, "Storage not writable.", Toast.LENGTH_LONG).show()
//        }
//
//        button2.setOnClickListener {
//            var results = readFileDirectlyAsText(getFilename(text_name_edit_text.text.toString()).toString())
//
//            content_text_view.text = results
//        }
    }

//    private fun isExternalStorageWritable(): Boolean {
//        val state = Environment.getExternalStorageState()
//        return Environment.MEDIA_MOUNTED == state
//    }
//
//    private fun getFilename(name: String): File {
//        fileToReadAndWrite = File("sdcard/Memos/", name)
//
//        return fileToReadAndWrite as File
//    }
//
//    private fun isFileWritable(file: File): Boolean {
//        return if (!file.canWrite()) {
//            file.setWritable(true)
//        } else file.canWrite()
//    }
//
//    fun readFileDirectlyAsText(fileName: String): String = File(fileName).readText(Charsets.UTF_8)
//
//
//
//    private fun writeToFile(message:String, file:File) {
//        try {
//            var writer = FileWriter(file)
//            writer.write(message)
//            writer.close()
//        } catch (e: FileNotFoundException) {
//            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
//        } catch (e: IOException) {
//            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
//
//        } catch (e: Exception) {
//            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
//        }
//    }
//
//





}
