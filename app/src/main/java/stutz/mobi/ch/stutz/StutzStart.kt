package stutz.mobi.ch.stutz

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_stutz_start.*

class StutzStart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stutz_start)

        person_suche_resultat.adapter = ArrayAdapter<String>(this, R.layout.person_suche_resultat_layout, R.id.gefundenePerson, mutableListOf("Pauli", "Petra"))

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
