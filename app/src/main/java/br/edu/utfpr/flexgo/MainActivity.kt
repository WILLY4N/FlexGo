package br.edu.utfpr.flexgo
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.utfpr.flexgo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val resultEthanol: String = "Abasteça com ETANOL"
    val resultGasoline: String = "Abasteça com GASOLINA"
    val select: String = "Selecione"
    val requestEthanolConsumption: String = "Informe Consumo ETANOL"
    val requestGasolineConsumption: String = "Informe Consumo GASOLINA"
    val requestEthanolPrice: String = "Informe Preço ETANOL"
    val requestGasolinePrice: String = "Informe Preço GASOLINA"
    val valueCannotBeZero: String = "Informe valor maior que Zero"
    val requiredField: String = "Obrigatório"
    val zero: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.topAppBar)

        clearFields()

        binding.vehicleSearch.setOnClickListener {
            val intent = Intent(this, ListVehiclesActivity::class.java)
            getResult.launch(intent)
        }

        binding.clearEthanolPrice.setOnClickListener {
            binding.ethanolPriceValue.text.clear()
            binding.ethanolPriceValue.error = null
        }

        binding.clearGasolinePrice.setOnClickListener {
            binding.gasolinePriceValue.text.clear()
            binding.gasolinePriceValue.error = null
        }

        binding.clear.setOnClickListener {
            clearFields()
        }

        binding.calculate.setOnClickListener {
            calculate()
        }

        if (savedInstanceState != null) {
            binding.selectedVehicle.text = savedInstanceState.getString("selected_vehicle")
            binding.kmLEtanol.editText?.setText(savedInstanceState.getString("ethanol_performance"))
            binding.kmLGasoline.editText?.setText(savedInstanceState.getString("gasoline_performance"))
            binding.result.text = savedInstanceState.getString("result")
            binding.resultAnalysis.text = savedInstanceState.getString("result_analysis")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("selected_vehicle", binding.selectedVehicle.text.toString())
        outState.putString("ethanol_performance", binding.kmLEtanol.editText?.text.toString())
        outState.putString("gasoline_performance", binding.kmLGasoline.editText?.text.toString())
        outState.putString("result", binding.result.text.toString())
        outState.putString("result_analysis", binding.resultAnalysis.text.toString())
    }

    private fun clearFields() {
        binding.main.clearFocus()
        binding.kmLEtanol.error = null
        binding.kmLGasoline.error = null
        binding.ethanolPriceValue.error = null
        binding.gasolinePriceValue.error = null
        binding.kmLEtanol.editText?.setText("")
        binding.kmLGasoline.editText?.setText("")
        binding.ethanolPriceValue.text?.clear()
        binding.gasolinePriceValue.text?.clear()
        binding.result.text = ""
        binding.resultAnalysis.text = ""
    }

    private val getResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { it ->
        if (it.resultCode == RESULT_OK) {
            val selectedVehicle = it.data?.getStringExtra("selected_vehicle") ?: select
            binding.selectedVehicle.text = selectedVehicle
        }
    }

    fun calculate() {
        if (!consumptionFieldsIsFilled() || !fuelPriceFieldsIsFilled()) {
            return
        } else {
            binding.main.clearFocus()

            val ethanolPerformance = binding.ethanolPriceValue.text.toString()
                .toDouble() / binding.kmLEtanol.editText?.text.toString().toDouble()
            val gasolinePerformance = binding.gasolinePriceValue.text.toString()
                .toDouble() / binding.kmLGasoline.editText?.text.toString().toDouble()

            if (gasolinePerformance < ethanolPerformance) {
                binding.result.text = resultGasoline
            } else {
                binding.result.text = resultEthanol
            }

            binding.resultAnalysis.text =
                "Etanol R$ ${binding.ethanolPriceValue.text} / ${binding.kmLEtanol.editText?.text} Km/L = R$ ${
                    String.format("%.2f",ethanolPerformance)} por Km rodado\n" +
                "Gasolina R$ ${binding.gasolinePriceValue.text} / ${binding.kmLGasoline.editText?.text} Km/L = R$ ${
                    String.format("%.2f",gasolinePerformance)} por Km rodado"

        }
    }

    fun consumptionFieldsIsFilled(): Boolean {
        binding.kmLEtanol.error = null
        binding.kmLGasoline.error = null

        if (binding.kmLEtanol.editText?.text.isNullOrEmpty() == true || binding.kmLEtanol.editText?.text.toString().toDouble() <= zero ) {
            binding.kmLEtanol.error = valueCannotBeZero
            binding.kmLEtanol.requestFocus()
            Toast.makeText(this, requestEthanolConsumption, Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.kmLGasoline.editText?.text.isNullOrEmpty() == true || binding.kmLGasoline.editText?.text.toString().toDouble() <= zero ) {
            binding.kmLGasoline.error = valueCannotBeZero
            binding.kmLGasoline.requestFocus()
            Toast.makeText(this, requestGasolineConsumption, Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun fuelPriceFieldsIsFilled(): Boolean {
        binding.ethanolPriceValue.error = null
        binding.gasolinePriceValue.error = null

        if (binding.ethanolPriceValue.text.isNullOrEmpty() == true) {
            binding.ethanolPriceValue.error = requiredField
            binding.ethanolPriceValue.requestFocus()
            Toast.makeText(this, requestEthanolPrice, Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.gasolinePriceValue.text.isNullOrEmpty() == true) {
            binding.gasolinePriceValue.error = requiredField
            binding.gasolinePriceValue.requestFocus()
            Toast.makeText(this, requestGasolinePrice, Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}