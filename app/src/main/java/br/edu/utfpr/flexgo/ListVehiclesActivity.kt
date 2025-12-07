package br.edu.utfpr.flexgo

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.flexgo.databinding.ActivityListVehiclesBinding

class ListVehiclesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListVehiclesBinding
    private lateinit var lvVehicles: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityListVehiclesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lvVehicles)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lvVehicles = binding.lvVehicles

        lvVehicles.setOnItemClickListener { parent, view, position, id ->
            val selectedVehicle = parent.getItemAtPosition(position) as String
            intent.putExtra("selected_vehicle", selectedVehicle)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}