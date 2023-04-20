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
            ["I can help you with travel recommendations, finding hotels, and planning itineraries.", ]
        ],
        [
            r"i want to go to (.*)",
            ["Sure, we can help with that. Which city or country would you like to visit in %1?", ]
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
            r"can you recommend some tourist attractions|places to visit",
            ["Certainly! What kind of attractions are you interested in? Museums, historical sites, natural wonders, or something else?", ]
        ],
        [
            r"what is the best time to visit (.*)",
            ["The best time to visit %1 depends on the season, weather, and local events. We can provide you with more information about the best time to visit %1. Would you like us to send you more information?", ]
        ],
        [
            r"i have a complaint|problem|issue",
            ["I'm sorry to hear that. Please provide me with more details about the issue and we'll do our best to resolve it for you.", ]
        ],
        [
            r"thank you for your help|thanks for the information|thank u for ur help",
            ["You're welcome! We're always here to assist you with your travel needs.", ]
        ],
        [
            r"(?:What is|Tell me about|about) Sigiriya\??",
            ["Sigiriya is an ancient rock fortress located in the central Matale District of Sri Lanka",
             "Sigiriya is a UNESCO World Heritage Site that dates back to the 5th century AD",
             "Sigiriya is also known as the Lion Rock due to the lion statue that once stood at the entrance to the fortress",
             "Sigiriya is considered to be one of the best preserved examples of ancient urban planning",
             "Sigiriya is a popular tourist destination and attracts visitors from around the world"]
        ],
        [
            r"What is the significance of Sigiriya|What is the historical importance of Sigiriya|Tell me importance about sigiriya",
            ["Sigiriya is a UNESCO World Heritage site and is known for its historic and cultural importance.",
             "Sigiriya is famous for its stunning rock fortress, gardens, and ancient frescoes.",
             "Sigiriya was built in the 5th century AD and is considered a masterpiece of ancient Sri Lankan engineering and architecture."]
        ],
        [
            r"When was Sigiriya built|What is the history of Sigiriya|Who built Sigiriya?",
            [
             "Sigiriya was built in the 5th century AD by King Kasyapa.",
             "King Kasyapa built Sigiriya in the 5th century AD.",
             "The construction of Sigiriya began in the 5th century AD under King Kasyapa.",
             "Sigiriya was built as a palace-fortress by King Kasyapa, who ruled Sri Lanka from 477 to 495 AD."
             ]
        ],
        [
            r"What is the height of Sigiriya(,|\\?)|How tall is Sigiriya(,|\\?)?",
            ["Sigiriya stands at a height of 200 meters (660 feet)", "The height of Sigiriya is around 200 meters (660 feet)", "The height of Sigiriya is approximately 200 meters (660 feet)"]
        ],
        [
            r"What is the shape of Sigiriya|What does Sigiriya look like?",
            ["Sigiriya is a massive column of rock that rises abruptly out of the flat landscape around it",
             "Sigiriya is a distinctive rock formation that resembles a giant lion's paw",
             "Sigiriya is often described as a fortress in the shape of a lion",
             "The shape of Sigiriya is unique and can be seen from miles away",
             "Sigiriya's shape is a marvel of engineering and architectural design"]
        ],
        [
            r"Can i climb Sigiriya|Is Sigiriya open to the public?",
            ["Yes, Sigiriya is open to the public and visitors can climb to the top of the rock."]
        ],
        [
             r"Can I buy Sigiriya entrance fees ticket online|can i buy tickets online for sigiriya",
             ["Not yet as of now but this will be online soon"]
         ],
        [
             r"What is the dress code for Sigiriya|What should I wear to visit Sigiriya|Is there a dress code for visiting Sigiriya Lion Rock|Can I wear shorts to visit Sigiriya Lion Rock|Are there any clothing restrictions for visiting Sigiriya Lion Rock?",
             ["Sigiriya is not a temple or any religious place and you can wear your own dress.",
              "There is no strict dress code, but it's recommended to wear comfortable clothes and footwear.",
              "While there is no official dress code, it's important to dress modestly out of respect for the cultural significance of the site."
             ]
         ],
        [
            r"Entrance fees for Sigiriya|How much is the entrance fee for Lion Rock Sigiriya?|Is there a discount on the entrance fee for other countries nationals?|What is the entrance fee for other countries nationals?|Is the entrance fee for Sigiriya (.*)",

            ["The entrance fee for Lion Rock Sigiriya is 30 USD per person for foreign nationals and 15 USD per person for SAARC countries nationals.",
             "If you are a SAARC countries national, you can get a discount on the entrance fee by submitting your passport. The discounted fee is 15 USD per person.",
             "Please note that entrance fees are subject to change, so it's always a good idea to check the latest information before your visit."
            ]
        ],
        [
            r"What are the opening hours of Sigiriya|When can visitors go to Sigiriya Lion Rock",
            ["7.00 AM to 5.00 PM", "The rock opens at 7 in the morning and closes at 5 in the evening.", "Visitors are allowed to enter Sigiriya Lion Rock from 7 am to 5 pm."]
        ],
        [
             r"Is it hard to climb Sigiriya|How high is Lion Rock|What should I be aware of before climbing Lion Rock Sigiriya?",
             [ "It is not necessarily dangerous to climb Lion Rock Sigiriya, but it can be physically challenging. Make sure you are healthy enough to climb the 1,200 steps to the top.", "Lion Rock Sigiriya rises approximately 660 feet (200 meters) above the surrounding landscape.","Before climbing Lion Rock Sigiriya, it's important to be aware of the weather conditions, wear comfortable and sturdy shoes, and bring plenty of water to stay hydrated."]
        ],
        [
            r"What is the significance of the water gardens at Sigiriya|What was the purpose of the water gardens at Sigiriya|What role did the water gardens play in the palace-fortress at Sigiriya?",
            [
             "The water gardens at Sigiriya were once an elaborate system of canals, fountains, and pools that provided water for the palace-fortress and its inhabitants.",
             "The water gardens also served a decorative purpose and were designed to enhance the beauty of the palace-fortress.",
             "In addition to providing water, the water gardens helped to cool the palace-fortress during the hot and humid months."
             ]
        ],
        [
            r"What do the frescoes at Sigiriya depict|Who is believed to be depicted in the frescoes at Sigiriya|What is the cultural value of the frescoes at Sigiriya?",
            [
             "The frescoes at Sigiriya depict women believed to be part of the king's harem and are known for their artistic and cultural value.",
             "The Sigiriya frescoes are considered one of the finest examples of ancient Sri Lankan art and provide valuable insights into the country's history and culture.",
             "The Sigiriya frescoes are also believed to have had a symbolic or religious significance and were possibly used for ritual or ceremonial purposes."
            ]
        ],
        [
            r"What is the importance of the lion's paws at the entrance of Sigiriya|What was the purpose of the lion statue at Sigiriya|Who built the lion statue at Sigiriya?",
            ["The lion's paws at the entrance of Sigiriya were part of a massive lion statue that once guarded the palace-fortress.",
             "The lion's paws are also thought to represent the strength and power of the ancient king who built Sigiriya.",
             "Some scholars believe that the lion's paws symbolize the king's authority and sovereignty over the land.",
             "It is not known for certain who built the lion statue at Sigiriya, but it is believed to have been constructed during the reign of King Kassapa I in the late 5th century AD."]
        ],
        [
            r"What is Ruwanweliseya|What is the importance of Ruwanweliseya?",
            ["Ruwanweliseya is a stupa located in Anuradhapura, Sri Lanka.", "Ruwanweliseya was built by King Dutugemunu in the 2nd century BC.", "Ruwanweliseya is considered to be one of the most sacred Buddhist sites in Sri Lanka.", "Ruwanweliseya is also known as the Swarnamali Chaitya or the Mahathupa." ]
        ],
        [
            r"How tall is Ruwanweliseya?",
            ["Ruwanweliseya is approximately 103 meters tall."]
        ],
        [
            r"When was Ruwanweliseya built?",
            ["Ruwanweliseya was built during the reign of King Dutugemunu in the 2nd century BCE."]
        ],
        [
            r"What is the architectural style of Ruwanweliseya?",
            ["Ruwanweliseya is an example of ancient Sinhalese architecture and is considered one of the greatest achievements of ancient Sri Lanka."]
        ],
        [
            r"Are there any dress codes to follow when visiting Ruwanweliseya|What is the dress code for visiting Ruwanweliseya|Is there a dress code for women visiting Ruwanweliseya|Can you tell me more about the dress code for visiting Ruwanweliseya?",
            ["Yes, visitors are required to dress modestly and cover their shoulders and knees when visiting Ruwanweliseya."]
        ],
        [
            r"Is photography allowed inside Ruwanweliseya|Are there any restrictions on photography inside Ruwanweliseya|Can I bring a camera inside Ruwanweliseya|What is the best time of day to take photos at Ruwanweliseya?",
            ["Yes, photography is allowed inside Ruwanweliseya.",
            "There are no major restrictions on photography inside Ruwanweliseya, but please be respectful of the sacred space and avoid using flash photography.",
            "Yes, you can bring a camera inside Ruwanweliseya to take photos of the temple and surrounding area.",
            "The best time of day to take photos at Ruwanweliseya is during sunrise or sunset when the light is soft and warm."]
        ],
        [
            r"What are some other famous places in Anuradhapura|tell me some other places in Anuradhapura",
            ["Anuradhapura is home to several other famous landmarks, including the Jetavanaramaya stupa, the Abhayagiri vihara, and the Sri Maha Bodhi tree."]
        ],
        [
            r"(.*)",
            [
              "I'm sorry, I didn't understand that. Could you please rephrase or provide more information?",
              "I'm not sure I understand. Can you please provide more context?",
              "Could you please rephrase that? I'm having trouble understanding.",
            ]
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
