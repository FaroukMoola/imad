import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

enum class Selection {
    ROCK, PAPER, SCISSOR
}

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonRock: Button
    private lateinit var buttonPaper: Button
    private lateinit var buttonScissor: Button

    private var userSelection = Selection.SCISSOR
    private var cpuSelection = Selection.ROCK
    private var userWinner = true
    private var matchDraw = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRock = findViewById(R.id.button_rock)
        buttonPaper = findViewById(R.id.button_paper)
        buttonScissor = findViewById(R.id.button_scissor)

        buttonRock.setOnClickListener(this)
        buttonPaper.setOnClickListener(this)
        buttonScissor.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_rock -> userSelection = Selection.ROCK
            R.id.button_paper -> userSelection = Selection.PAPER
            R.id.button_scissor -> userSelection = Selection.SCISSOR
        }
        proceed()
    }

    private fun proceed() {
        cpuSelection = getRandomCPUSelection()
        checkWinner()
        showWinner()
    }

    private fun getRandomCPUSelection(): Selection {
        val random = (0..2).random()
        return when (random) {
            0 -> Selection.ROCK
            1 -> Selection.PAPER
            2 -> Selection.SCISSOR
            else -> Selection.ROCK
        }
    }

    private fun checkWinner() {
        if (userSelection == cpuSelection) {
            matchDraw = true
            return
        }
        when (userSelection) {
            Selection.ROCK -> {
                if (cpuSelection == Selection.SCISSOR) userWinner = true else userWinner = false
            }
            Selection.PAPER -> {
                if (cpuSelection == Selection.ROCK) userWinner = true else userWinner = false
            }
            Selection.SCISSOR -> {
                if (cpuSelection == Selection.PAPER) userWinner = true else userWinner = false
            }
        }
    }

    private fun showWinner() {
        val message = if (matchDraw) "It's a draw!" else if (userWinner) "You win!" else "You lose!"
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("Play Again") { _, _ -> }
            .show()
    }
}import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

enum class Selection {
    ROCK, PAPER, SCISSOR
}

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonRock: Button
    private lateinit var buttonPaper: Button
    private lateinit var buttonScissor: Button

    private var userSelection = Selection.SCISSOR
    private var cpuSelection = Selection.ROCK
    private var userWinner = true
    private var matchDraw = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRock = findViewById(R.id.button_rock)
        buttonPaper = findViewById(R.id.button_paper)
        buttonScissor = findViewById(R.id.button_scissor)

        buttonRock.setOnClickListener(this)
        buttonPaper.setOnClickListener(this)
        buttonScissor.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_rock -> userSelection = Selection.ROCK
            R.id.button_paper -> userSelection = Selection.PAPER
            R.id.button_scissor -> userSelection = Selection.SCISSOR
        }
        proceed()
    }

    private fun proceed() {
        cpuSelection = getRandomCPUSelection()
        checkWinner()
        showWinner()
    }

    private fun getRandomCPUSelection(): Selection {
        val random = (0..2).random()
        return when (random) {
            0 -> Selection.ROCK
            1 -> Selection.PAPER
            2 -> Selection.SCISSOR
            else -> Selection.ROCK
        }
    }

    private fun checkWinner() {
        if (userSelection == cpuSelection) {
            matchDraw = true
            return
        }
        when (userSelection) {
            Selection.ROCK -> {
                if (cpuSelection == Selection.SCISSOR) userWinner = true else userWinner = false
            }
            Selection.PAPER -> {
                if (cpuSelection == Selection.ROCK) userWinner = true else userWinner = false
            }
            Selection.SCISSOR -> {
                if (cpuSelection == Selection.PAPER) userWinner = true else userWinner = false
            }
        }
    }

    private fun showWinner() {
        val message = if (matchDraw) "It's a draw!" else if (userWinner) "You win!" else "You lose!"
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("Play Again") { _, _ -> }
            .show()
    }
}
