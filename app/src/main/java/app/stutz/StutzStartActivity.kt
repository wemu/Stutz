package app.stutz

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import app.stutz.person.suchen.model.Person
import app.stutz.person.suchen.adapter.PersonAdapter
import app.stutz.person.PersonRepo
import app.stutz.person.PersonRepoStore
import kotlinx.android.synthetic.main.activity_stutz_start.*

class StutzStartActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = getMenuInflater()
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    fun loginclicked(menuItem: MenuItem) {
        val intent = Intent("app.stutz.LOGIN")
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stutz_start)
        setSupportActionBar(toolbar2)

        val persRepo = PersonRepo()

        val persAdapter = PersonAdapter(this, persRepo.search(nameSuchePerson.text.toString()))
        PersonRepoStore.addObserver(persAdapter)
        person_suche_resultat.adapter = persAdapter

        nameSuchePerson.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val adapter = person_suche_resultat.adapter as ArrayAdapter<Person>
                adapter.clear()
                adapter.addAll(PersonRepo().search(s.toString()))
            }
        })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        person_suche_resultat.setOnItemClickListener  { _:Any, _: View, position:Int, _:Long ->
            val person: Person = person_suche_resultat.adapter.getItem(position) as Person

            val i = Intent("app.stutz.select_spende")
            i.putExtra("app.stutz.EXTRA_PERSON_ID", person.id.toString())
            startActivity(i)
        }
    }

}
