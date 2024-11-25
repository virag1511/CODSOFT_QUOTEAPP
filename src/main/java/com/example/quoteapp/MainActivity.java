package com.example.quoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private TextView authorTextView;
    private List<Quote> quotes;
    private Quote currentQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        authorTextView = findViewById(R.id.authorTextView);
        Button shareButton = findViewById(R.id.shareButton);
        Button favoriteButton = findViewById(R.id.favoriteButton);
        Button refreshButton = findViewById(R.id.refreshButton);

        // Sample quotes
        quotes = new ArrayList<>();
        quotes.add(new Quote("The only way to do great work is to love what you do.", "Steve Jobs"));
        quotes.add(new Quote("Life is what happens when you're busy making other plans.", "John Lennon"));
        quotes.add(new Quote("Get busy living or get busy dying.", "Stephen King"));
        quotes.add(new Quote("The only way to do great work is to love what you do.", "Steve Jobs"));
        quotes.add(new Quote("Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.", "Albert Schweitzer"));
        quotes.add(new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"));
        quotes.add(new Quote("Your time is limited, don't waste it living someone else's life.", "Steve Jobs"));
        quotes.add(new Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"));
        quotes.add(new Quote("It does not matter how slowly you go as long as you do not stop.", "Confucius"));
        quotes.add(new Quote("What lies behind us and what lies before us are tiny matters compared to what lies within us.", "Ralph Waldo Emerson"));
        quotes.add(new Quote("The best way to predict the future is to create it.", "Peter Drucker"));
        quotes.add(new Quote("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"));
        quotes.add(new Quote("Everything you’ve ever wanted is on the other side of fear.", "George Addair"));
        quotes.add(new Quote("Success usually comes to those who are too busy to be looking for it.", "Henry David Thoreau"));
        quotes.add(new Quote("Don’t watch the clock; do what it does. Keep going.", "Sam Levenson"));
        quotes.add(new Quote("The only limit to our realization of tomorrow will be our doubts of today.", "Franklin D. Roosevelt"));
        quotes.add(new Quote("You miss 100% of the shots you don’t take.", "Wayne Gretzky"));
        quotes.add(new Quote("Act as if what you do makes a difference. It does.", "William James"));
        quotes.add(new Quote("Success is not final, failure is not fatal: It is the courage to continue that counts.", "Winston S. Churchill"));
        quotes.add(new Quote("What you get by achieving your goals is not as important as what you become by achieving your goals.", "Zig Ziglar"));
        quotes.add(new Quote("The only way to achieve the impossible is to believe it is possible.", "Charles Kingsleigh (Alice in Wonderland)"));
        quotes.add(new Quote("Dream big and dare to fail.", "Norman Vaughan"));
        quotes.add(new Quote("If you can dream it, you can do it.", "Walt Disney"));
        quotes.add(new Quote("The future depends on what you do today.", "Mahatma Gandhi"));
        quotes.add(new Quote("In the middle of every difficulty lies opportunity.", "Albert Einstein"));
        quotes.add(new Quote("Keep your face always toward the sunshine—and shadows will fall behind you.", "Walt Whitman"));
        quotes.add(new Quote("Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.", "Christian D. Larson"));
        quotes.add(new Quote("The only person you are destined to become is the person you decide to be.", "Ralph Waldo Emerson"));
        quotes.add(new Quote("It’s not whether you get knocked down, it’s whether you get up.", "Vince Lombardi"));
        quotes.add(new Quote("Hardships often prepare ordinary people for an extraordinary destiny.", "C.S. Lewis"));
        // Add more quotes as needed

        // Display a random quote on startup
        displayRandomQuote();

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFavorite();
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomQuote();
            }
        });
    }

    private void displayRandomQuote() {
        Random random = new Random();
        currentQuote = quotes.get(random.nextInt(quotes.size()));
        quoteTextView.setText(currentQuote.getQuote());
        authorTextView.setText(currentQuote.getAuthor());
    }

    private void shareQuote() {
        if (currentQuote != null) {
            String shareText = "\"" + currentQuote.getQuote() + "\" - " + currentQuote.getAuthor();
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(shareIntent, "Share Quote"));
        }
    }

    private void saveFavorite() {
        // Implement saving to favorites (could use SharedPreferences or a database)
        Toast.makeText(this, "Quote saved to favorites!", Toast.LENGTH_SHORT).show();
    }

    // Quote model class
    private static class Quote {
        private String quote;
        private String author;

        public Quote(String quote, String author) {
            this.quote = quote;
            this.author = author;
        }

        public String getQuote() {
            return quote;
        }

        public String getAuthor() {
            return author;
        }
    }
}
