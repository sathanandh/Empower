import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val dropdownItems = arrayOf("Option 1", "Option 2", "Option 3")
        val dropdown = findViewById<Spinner>(R.id.dropdown)
        val table = findViewById<TableLayout>(R.id.table)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropdown.adapter = adapter

        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedOption = dropdownItems[position]
                addRowToTable(selectedOption)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle if nothing is selected
            }
        }
    }

    private fun addRowToTable(selectedOption: String) {
        val row = TableRow(this)
        val cell1 = TextView(this)
        cell1.text = selectedOption
        val cell2 = TextView(this)
        cell2.text = "Value for column 2"  // Replace with actual values
        row.addView(cell1)
        row.addView(cell2)
        table.addView(row)
    }
}
