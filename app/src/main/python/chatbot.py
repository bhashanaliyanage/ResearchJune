import nltk
nltk.download('vader_lexicon')
from nltk.sentiment import SentimentIntensityAnalyzer
from nltk.chat.util import Chat, reflections


def main(inputData):
    # Creating Pairs
    pairs = [
        [
            r"hi|hey|hello",
            ["Hello, welcome to our travel chatbot! How can I assist you today?", ]
        ],
        [
            r"what can you do|what services do you offer|what do you offer",
            ["I can help you with travel recommendations, booking flights, finding hotels, and planning itineraries.", ]
        ],
        [
            r"i want to go to (.*)",
            ["Sure, we can help with that. Which city or country would you like to visit in %1?", ]
        ],
        [
            r"(.*) in (.*)",
            ["Yes, we can recommend some popular %1 in %2. What's your budget like?", ]
        ],
        [
            r"my budget is (\d+)",
            ["Great, we have some options that fit within your budget. Would you like us to send you some recommendations?", ]
        ],
        [
            r"yes|sure|ok|send it",
            ["We'll send you an email with some recommendations shortly. Is there anything else you need help with?", ]
        ],
        [
            r"no|not right now|thanks",
            ["Alright, feel free to reach out to us if you need any further assistance. Have a great day!", ]
        ],
        [
            r"thank you|thanks",
            ["You're welcome! It was my pleasure to assist you.", ]
        ],
        [
            r"bye|goodbye",
            ["Goodbye! Have a safe and enjoyable trip!", ]
        ],
        [
            r"(.*)",
            ["I'm sorry, I didn't understand that. Could you please rephrase or provide more information?", ]
        ],
    ]

    # Creating reflections
    my_reflections = {
        "i am": "you are",
        "i was": "you were",
        "i": "you",
        "i'm": "you are",
        "i'd": "you would",
        "i've": "you have",
        "i'll": "you will",
        "my": "your",
        "you are": "I am",
        "you were": "I was",
        "you've": "I have",
        "you'll": "I will",
        "your": "my",
        "yours": "mine",
        "you": "me",
        "me": "you"
    }

    # Creating sentiment analyzer
    sia = SentimentIntensityAnalyzer()

    # Defining function to get sentiment score
    def get_sentiment(input_str):
        return sia.polarity_scores(input_str)["compound"]

    # Creating chatbot
    chatbot = Chat(pairs, my_reflections)

    # Getting response from chatbot
    response = chatbot.respond(inputData)

    # Getting sentiment score for response
    sentiment_score = get_sentiment(response)

    # Classifying sentiment
    if sentiment_score >= 0.5:
        sentiment = "positive"
    elif sentiment_score <= -0.5:
        sentiment = "negative"
    else:
        sentiment = "neutral"

    # Adding sentiment information to response
    response += "\nSentiment: " + sentiment

    return response
