package com.example.image_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewDetailsActivity extends AppCompatActivity {

    ImageView image;
    TextView result, head, details;

    FloatingActionButton maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        image = findViewById(R.id.imageView);
        result = findViewById(R.id.result);
        head = findViewById(R.id.title);
        details = findViewById(R.id.details);
        maps = findViewById(R.id.map);

        Intent intent = getIntent();
        String text = intent.getStringExtra("key");
        Bitmap bitmap = intent.getParcelableExtra("image");

        image.setImageBitmap(bitmap);

        result.setText(text);
        result.setVisibility(View.GONE);
        String res = result.getText().toString();

        if (res.equals("somawathiya")) {
            head.setText("Somawathiya Temple");
            details.setText("Somawathiya Temple, also known as Somawathi Stupa, is an ancient Buddhist temple located in the Polonnaruwa District of Sri Lanka. It holds great religious and historical significance and is revered by Buddhists in the country. Here are some details about Somawathiya Temple:\n" +
                    "\n" +
                    "Location: Somawathiya Temple is situated in the Mahaweli River basin in the Somawathiya National Park, approximately 40 kilometers northeast of Polonnaruwa town in Sri Lanka. It is nestled amidst a scenic natural setting, surrounded by lush greenery and wildlife.\n" +
                    "\n" +
                    "Historical Significance: The temple dates back to ancient times and is believed to have been built during the reign of King Kavantissa (205–161 BC) in the Anuradhapura era. It is mentioned in the ancient Buddhist chronicle, the Mahavamsa, and is considered one of the sixteen sacred places visited by Gautama Buddha during his third visit to Sri Lanka.\n" +
                    "\n" +
                    "Somawathi Stupa: The main feature of the temple is the Somawathi Stupa, a large and imposing brick structure with a unique architectural design. The stupa is believed to enshrine a sacred relic of Lord Buddha, specifically a hair relic. It has undergone several renovations and restorations throughout history.\n" +
                    "\n" +
                    "Pilgrimage Site: Somawathiya Temple is a popular pilgrimage site for Buddhists, who visit the temple to pay homage, offer prayers, and seek blessings. The temple attracts a large number of devotees, especially during religious festivals and full moon days.\n" +
                    "\n" +
                    "Festivals: The annual Esala Perahera is one of the most significant festivals celebrated at Somawathiya Temple. It involves a grand procession with traditional dancers, drummers, and elephants parading around the temple complex. The festival draws thousands of devotees and spectators from all parts of the country.\n" +
                    "\n" +
                    "Somawathiya National Park: The temple is located within the Somawathiya National Park, which is known for its rich biodiversity and natural beauty. The park is home to a variety of wildlife, including elephants, leopards, deer, and numerous bird species. Visitors can enjoy the serene surroundings and engage in nature exploration and wildlife observation.\n" +
                    "\n" +
                    "Facilities: The temple complex provides basic facilities for visitors, including a shrine room, meditation area, accommodation for pilgrims, and a rest house. There are also stalls selling religious items and offerings.\n" +
                    "\n" +
                    "Visiting Somawathiya Temple offers a unique spiritual and cultural experience, allowing visitors to connect with Sri Lanka's ancient Buddhist heritage amidst beautiful natural surroundings.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.120940118236325;
                double longitude = 81.16884755956998;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (res.equals("abayagiriya")) {
            head.setText("Abhayagiriya Temple");
            details.setText("Abhayagiriya Temple, also known as Abhayagiri Monastery, is an ancient Buddhist monastery located in the historic city of Anuradhapura in Sri Lanka. It holds significant religious and historical importance as one of the major monastic complexes of the Anuradhapura Kingdom. Here are some details about Abhayagiriya Temple:\n" +
                    "\n" +
                    "Location: Abhayagiriya Temple is situated in the sacred city of Anuradhapura, which was the capital of ancient Sri Lanka. It is located in the North Central Province of Sri Lanka, approximately 205 kilometers north of Colombo.\n" +
                    "\n" +
                    "Historical Significance: The temple complex was established in the 1st century BC by King Vattagamani Abhaya (Valagamba) during the Anuradhapura period. It flourished as a center of Buddhist learning and practice and became one of the largest monastic establishments in the region.\n" +
                    "\n" +
                    "Monastic Complex: Abhayagiriya was not just a single temple but a vast monastic complex covering a large area. It consisted of numerous structures, including stupas, monastic buildings, meditation halls, libraries, and other ancillary structures. The complex was a hub of religious, educational, and cultural activities.\n" +
                    "\n" +
                    "Stupas: The most prominent feature of Abhayagiriya Temple is the towering Abhayagiri Stupa. It was originally built to enshrine the relics of the Buddha and stood as one of the tallest structures in the ancient world. The stupa has undergone multiple renovations over the centuries.\n" +
                    "\n" +
                    "International Influence: Abhayagiriya Temple had significant international influence, attracting scholars, monks, and pilgrims from various countries, including India, China, and Southeast Asian nations. It served as a center for the exchange of Buddhist teachings and cultural interactions.\n" +
                    "\n" +
                    "Decline and Restoration: The temple complex faced periods of decline and abandonment due to various historical events, including invasions and internal conflicts. However, in recent years, restoration efforts have been undertaken to preserve and revive the ancient structures and the spiritual heritage of the site.\n" +
                    "\n" +
                    "Tourist Attraction: Today, Abhayagiriya Temple is a popular tourist destination and a UNESCO World Heritage Site. Visitors can explore the ruins of the ancient monastic complex, marvel at the grandeur of the Abhayagiri Stupa, and witness the archaeological treasures that have been unearthed.\n" +
                    "\n" +
                    "Visiting Abhayagiriya Temple provides a glimpse into the rich Buddhist heritage of Sri Lanka and offers an opportunity to appreciate the architectural grandeur and spiritual significance associated with this ancient monastic complex.");


            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.370954124237167;
                double longitude = 80.39528061740592;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("jethawanaramaya")) {
            head.setText("Jetavanaramaya Temple");
            details.setText("Abhayagiriya Temple, also known as Abhayagiri Monastery, is an ancient Buddhist monastery located in the historic city of Anuradhapura in Sri Lanka. It holds significant religious and historical importance as one of the major monastic complexes of the Anuradhapura Kingdom. Here are some details about Abhayagiriya Temple:\n" +
                    "\n" +
                    "Location: Abhayagiriya Temple is situated in the sacred city of Anuradhapura, which was the capital of ancient Sri Lanka. It is located in the North Central Province of Sri Lanka, approximately 205 kilometers north of Colombo.\n" +
                    "\n" +
                    "Historical Significance: The temple complex was established in the 1st century BC by King Vattagamani Abhaya (Valagamba) during the Anuradhapura period. It flourished as a center of Buddhist learning and practice and became one of the largest monastic establishments in the region.\n" +
                    "\n" +
                    "Monastic Complex: Abhayagiriya was not just a single temple but a vast monastic complex covering a large area. It consisted of numerous structures, including stupas, monastic buildings, meditation halls, libraries, and other ancillary structures. The complex was a hub of religious, educational, and cultural activities.\n" +
                    "\n" +
                    "Stupas: The most prominent feature of Abhayagiriya Temple is the towering Abhayagiri Stupa. It was originally built to enshrine the relics of the Buddha and stood as one of the tallest structures in the ancient world. The stupa has undergone multiple renovations over the centuries.\n" +
                    "\n" +
                    "International Influence: Abhayagiriya Temple had significant international influence, attracting scholars, monks, and pilgrims from various countries, including India, China, and Southeast Asian nations. It served as a center for the exchange of Buddhist teachings and cultural interactions.\n" +
                    "\n" +
                    "Decline and Restoration: The temple complex faced periods of decline and abandonment due to various historical events, including invasions and internal conflicts. However, in recent years, restoration efforts have been undertaken to preserve and revive the ancient structures and the spiritual heritage of the site.\n" +
                    "\n" +
                    "Tourist Attraction: Today, Abhayagiriya Temple is a popular tourist destination and a UNESCO World Heritage Site. Visitors can explore the ruins of the ancient monastic complex, marvel at the grandeur of the Abhayagiri Stupa, and witness the archaeological treasures that have been unearthed.\n" +
                    "\n" +
                    "Visiting Abhayagiriya Temple provides a glimpse into the rich Buddhist heritage of Sri Lanka and offers an opportunity to appreciate the architectural grandeur and spiritual significance associated with this ancient monastic complex.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "User\n" +
                    "jethawanaramaya temple\n" +
                    "\n" +
                    "ChatGPT\n" +
                    "Jetavanaramaya Temple, also known as Jetavanarama or Jethawanaramaya, is a renowned ancient Buddhist temple located in the sacred city of Anuradhapura in Sri Lanka. It is one of the most significant and largest stupas in the world. Here are some details about Jetavanaramaya Temple:\n" +
                    "\n" +
                    "Location: Jetavanaramaya Temple is situated in Anuradhapura, which was the capital of ancient Sri Lanka. It is located in the North Central Province of Sri Lanka, approximately 205 kilometers north of Colombo.\n" +
                    "\n" +
                    "Historical Significance: The temple was constructed during the reign of King Mahasena (273–301 AD) of the Anuradhapura Kingdom. It was built to enshrine the relics of the Buddha and to serve as a place of worship and veneration for Buddhist devotees.\n" +
                    "\n" +
                    "Stupa: The main feature of Jetavanaramaya Temple is the Jetavanaramaya Stupa, which is one of the largest brick structures in the world. It stands at a height of approximately 122 meters (400 feet) and covers an area of about 5.6 hectares. The stupa was meticulously constructed with bricks and adorned with intricate architectural details.\n" +
                    "\n" +
                    "Architectural Marvel: Jetavanaramaya Stupa is considered a remarkable engineering and architectural feat of ancient Sri Lanka. It showcases the advanced construction techniques employed during that era, including the use of precise brickwork and a complex network of corridors and chambers within the stupa.\n" +
                    "\n" +
                    "Pilgrimage Site: Jetavanaramaya Temple is a significant pilgrimage site for Buddhists in Sri Lanka. Devotees visit the temple to pay homage, offer prayers, and engage in religious rituals. The temple complex attracts a large number of visitors, especially during religious festivals and full moon days.\n" +
                    "\n" +
                    "Conservation and Restoration: Over the years, the temple complex has undergone several restoration efforts to preserve its historical and religious significance. The stupa has been conserved to prevent further deterioration, and archaeological excavations have revealed important artifacts and remains associated with the temple.\n" +
                    "\n" +
                    "Tourist Attraction: Jetavanaramaya Temple is a popular tourist destination and a UNESCO World Heritage Site. Visitors can explore the temple complex, appreciate the grandeur of the stupa, and learn about the rich Buddhist heritage of Sri Lanka.\n" +
                    "\n" +
                    "Visiting Jetavanaramaya Temple offers a unique opportunity to witness the architectural brilliance of ancient Sri Lanka and to experience the spiritual ambiance of this revered Buddhist site.");


            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.351580523860767;
                double longitude = 80.40368630518427;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("kelaniya")) {
            head.setText("Kelaniya Raja Maha Viharaya");
            details.setText("Kelaniya Raja Maha Viharaya, commonly known as Kelaniya Temple, is a revered Buddhist temple located in Kelaniya, a suburb of Colombo, the capital city of Sri Lanka. The temple holds significant religious and historical importance and is considered one of the holiest sites in the country. Here are some details about Kelaniya Temple:\n" +
                    "\n" +
                    "Location: Kelaniya Temple is situated on the banks of the Kelani River in the town of Kelaniya, approximately 10 kilometers northeast of Colombo. It is easily accessible and attracts both local devotees and tourists.\n" +
                    "\n" +
                    "Historical Significance: According to Buddhist tradition, the temple dates back to the time of Lord Buddha's third visit to Sri Lanka, around 500 BCE. It is believed that the temple was established on the spot where Lord Buddha preached the Dhamma (Buddhist teachings) to a gathering of deities and humans.\n" +
                    "\n" +
                    "Sacred Relics: Kelaniya Temple is renowned for housing several sacred relics and objects of worship. The most significant relic is a gem-studded throne believed to have been used by Lord Buddha. It is enshrined within the temple and attracts devotees seeking blessings and spiritual solace.\n" +
                    "\n" +
                    "Architectural Beauty: The temple boasts impressive architectural features, blending traditional Sri Lankan and South Indian architectural styles. The main shrine, known as the \"Vihara Mandiraya,\" is adorned with intricate wood carvings, vibrant murals depicting Buddhist stories, and ornate decorations.\n" +
                    "\n" +
                    "Bo Tree: A sacred Bodhi tree, known as \"Jaya Sri Maha Bodhi,\" stands within the temple complex. It is believed to be a sapling from the historical Sri Maha Bodhi tree in Anuradhapura, under which Lord Buddha attained enlightenment. Devotees offer prayers and make offerings to the Bodhi tree for blessings and spiritual guidance.\n" +
                    "\n" +
                    "Cultural Significance: Kelaniya Temple holds great cultural significance in Sri Lanka. It is a center for Buddhist worship, meditation, and religious ceremonies. The temple is particularly vibrant during important Buddhist festivals such as Vesak, where devotees gather to engage in religious activities and witness colorful processions and rituals.\n" +
                    "\n" +
                    "Tourist Attraction: Kelaniya Temple is a popular tourist destination for both locals and international visitors. The serene and spiritual ambiance, along with the historical and architectural marvels, make it a captivating place to explore and experience the essence of Buddhism in Sri Lanka.\n" +
                    "\n" +
                    "Visiting Kelaniya Temple provides an opportunity to immerse oneself in the rich Buddhist heritage of Sri Lanka, witness the devotion of the worshippers, and appreciate the architectural and artistic beauty of the temple.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 6.951588965418413;
                double longitude = 79.91863948433735;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("lankaramaya")) {
            head.setText("Lankaramaya Stupa");
            details.setText("The Lankaramaya Stupa was built on the 1sy century BC by King Vattagamini Abaya. The ancient name of this temple is “Silasobbha Khandaka Cetiya”.After the defeat by the Tamil invaders on the same year he came to the throne king Walagamba has hidden in a place called” Silasobhha Khandaka” and after defeating the Tamils and regaining the throne he has built this stupa by the same name." +
                    "\n" +
                    "This stupa is similar to Thuparama which is the first stupa built after Buddhism was brought to the country in the 250 BC. This stupa too has had a magnificent vatadage surrounding the stupa. There are indications of eighty eight stone pillars have supported the roof of the vatadage. Today only few remains are out of these." +
                    "\n" +
                    "The History\n" +
                    "\n" +
                    "Appointed by King Valagamba of Anuradhapura is in the 1st Century BC that the Lankaramaya monastic complex contains a very well-renovated stupa among other things. The King ruled the country during an exceptionally troubled time, which is full of uncertainly thanks to South Indian invasions and revolutions by the Jain and Brahman community. They dissatisfied by the fact that the new Buddhist regime was ignoring their faiths.\n" +
                    "\n" +
                    "Thus Valagamba the youngest sin of Saddatissa and nephew of Dutugamunu had to go into hiding with his family many times and launch sporadic attacks and quick conflictsasconflicting to actually fighting the invaders head on. He had a few chances to get back onto the throne but he ended up having to leave just as quickly whenever the invader was too powerful for him to handle." +
                    "\n" +
                    "Appearance\n" +
                    "\n" +
                    "One of his hide ways was the area known as Silasobbha Khandaka and the original name of this temple was indeed Silasobbha Khandaka Cetiya. In its prime this monastic complex must have been a true wonder with its great stupa as the centerpiece raised up on a high a high platformin a curricular courtyard of sand about 1332 feet in diameter and surrounded by a low wall. The collaborative is in its entirety includes the universal moonstones and erect guardian stones. The most compelling feature that it used to include was an eighty eight columned vatadage. Nowadays, scarcely any of the original pillars keep on even proactive building or Vatadage that one would have supported a great wooden roof. This is quite a surprise considering the sheer size of Lankaramaya. India meter the stupa is forty five feet across.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.36547055215871;
                double longitude = 80.39150215148199;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("mirisawatiya")) {
            head.setText("Mirisawatiya Temple");
            details.setText("Mirisawatiya Temple, also known as Mirisaveti Stupa, is an ancient Buddhist temple located in the sacred city of Anuradhapura in Sri Lanka. It is an important religious site and a popular destination for Buddhist pilgrims and tourists. Here are some details about Mirisawatiya Temple:\n" +
                    "\n" +
                    "Location: Mirisawatiya Temple is situated in Anuradhapura, which was the capital of ancient Sri Lanka. It is located in the North Central Province of Sri Lanka, approximately 205 kilometers north of Colombo.\n" +
                    "\n" +
                    "Historical Significance: The temple is believed to have been built by King Dutugemunu in the 2nd century BC. It is closely associated with the historical events surrounding the reign of King Dutugemunu, who united Sri Lanka and played a significant role in the spread of Buddhism.\n" +
                    "\n" +
                    "Stupa: The main feature of Mirisawatiya Temple is the Mirisawatiya Stupa, a large dome-shaped structure that enshrines sacred relics. The stupa stands at a height of approximately 60 feet and has a circumference of about 164 feet. It is an important place of worship for Buddhists.\n" +
                    "\n" +
                    "Architectural Beauty: The stupa showcases the architectural expertise of ancient Sri Lanka. It is built using brick and stone, and the exterior is adorned with decorative elements and carvings. The stupa has undergone several renovations and restorations over the centuries to preserve its beauty and significance.\n" +
                    "\n" +
                    "Buddhist Pilgrimage Site: Mirisawatiya Temple is considered a significant pilgrimage site for Buddhists. Devotees visit the temple to pay homage, offer prayers, and engage in religious rituals. It is particularly popular during Buddhist festivals and full moon days.\n" +
                    "\n" +
                    "Sacred Bo Tree: Mirisawatiya Temple is also known for its sacred Bodhi tree, which is believed to be a sapling from the Jaya Sri Maha Bodhi tree in Anuradhapura, the oldest living human-planted tree in the world. The Bodhi tree is revered by devotees and is a focal point for meditation and worship.\n" +
                    "\n" +
                    "Cultural and Historical Importance: Mirisawatiya Temple is a significant cultural and historical site in Sri Lanka. It reflects the rich Buddhist heritage of the country and provides insights into ancient Sri Lankan architecture, religious practices, and the legacy of King Dutugemunu.\n" +
                    "\n" +
                    "Visiting Mirisawatiya Temple allows visitors to appreciate the religious and historical significance of the site, experience the serene atmosphere, and learn more about the rich Buddhist heritage of Sri Lanka.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.344946427750413;
                double longitude = 80.38897674439787;


                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("ridi viharaya")) {
            head.setText("Ridi Viharaya Temple");
            details.setText("Ridi Viharaya Temple, also known as Ridi Pagoda or Ridi Temple, is a revered Buddhist temple located in the town of Ridigama in the Kurunegala District of Sri Lanka. It is a prominent religious site that holds historical and cultural significance. Here are some details about Ridi Viharaya Temple:\n" +
                    "\n" +
                    "Location: Ridi Viharaya Temple is situated in Ridigama, a town in the Kurunegala District of Sri Lanka. It is located approximately 83 kilometers northwest of Colombo, the capital city of Sri Lanka.\n" +
                    "\n" +
                    "Historical Significance: The temple has a history dating back over 2,000 years. It is believed to have been founded during the reign of King Dutugemunu in the 2nd century BC. The temple played a significant role in the spread and preservation of Buddhism in the region.\n" +
                    "\n" +
                    "Sacred Relic: Ridi Viharaya Temple is renowned for housing a sacred tooth relic believed to be a tooth relic of Lord Buddha. This relic is highly venerated by Buddhist devotees who visit the temple to pay their respects and seek blessings.\n" +
                    "\n" +
                    "Architectural Features: The temple complex exhibits a blend of architectural styles, including Sinhalese, Indian, and South Indian influences. The main stupa, known as \"Ridi Seya,\" is a prominent feature of the temple. It is built in a dome shape and decorated with intricate stone carvings and sculptures.\n" +
                    "\n" +
                    "Cultural Significance: Ridi Viharaya Temple is a place of religious and cultural significance in Sri Lanka. It attracts a large number of devotees, especially during religious festivals and auspicious days. The temple complex is adorned with colorful decorations and illuminations during these occasions.\n" +
                    "\n" +
                    "Bo Tree: The temple complex also features a sacred Bodhi tree, which is believed to be a sapling from the Jaya Sri Maha Bodhi tree in Anuradhapura. The Bodhi tree holds symbolic value and is a focal point for Buddhist worship and meditation.\n" +
                    "\n" +
                    "Tourist Attraction: Ridi Viharaya Temple is not only a place of worship but also a popular tourist destination. Visitors can explore the temple complex, admire the architectural splendor, and witness the devotion of the worshippers. The serene surroundings and historical ambiance make it a captivating place to visit.\n" +
                    "\n" +
                    "Visiting Ridi Viharaya Temple offers an opportunity to experience the spiritual and cultural heritage of Sri Lanka, appreciate the architectural marvels, and witness the devotion of Buddhist followers.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 7.538911321046508;
                double longitude = 80.49082751468809;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("ruwanwalisaya")) {
            head.setText("Ruwanwelisaya Temple");
            details.setText("Ruwanwelisaya Temple, also known as Ruwanweliseya Stupa or Ruwanweli Seya, is an ancient Buddhist temple located in the sacred city of Anuradhapura in Sri Lanka. It is one of the most revered and iconic religious sites in the country. Here are some details about Ruwanwelisaya Temple:\n" +
                    "\n" +
                    "Location: Ruwanwelisaya Temple is situated in Anuradhapura, which was the capital of ancient Sri Lanka. It is located in the North Central Province of Sri Lanka, approximately 205 kilometers north of Colombo.\n" +
                    "\n" +
                    "Historical Significance: The temple was constructed during the reign of King Dutugemunu (161–137 BC), a prominent ruler in Sri Lankan history. It was built to enshrine sacred relics of Lord Buddha and to serve as a symbol of Buddhist faith and unity.\n" +
                    "\n" +
                    "Stupa: The main feature of Ruwanwelisaya Temple is the Ruwanwelisaya Stupa, which is a large hemispherical dome-shaped structure. It stands at a height of approximately 103 meters (338 feet) and has a circumference of about 290 meters (951 feet). The stupa is considered one of the tallest and largest stupas in Sri Lanka.\n" +
                    "\n" +
                    "Architectural Marvel: Ruwanwelisaya Stupa showcases the architectural brilliance of ancient Sri Lanka. It is constructed using brick and stone, and the outer surface is adorned with intricate carvings, decorative patterns, and terracotta designs. The stupa is topped with a spire and a pinnacle, adding to its grandeur.\n" +
                    "\n" +
                    "Buddhist Pilgrimage Site: Ruwanwelisaya Temple holds great religious significance for Buddhists in Sri Lanka. It is a major pilgrimage site where devotees visit to pay homage, offer prayers, and engage in religious rituals. The temple complex is particularly busy during religious festivals and full moon days.\n" +
                    "\n" +
                    "Conservation and Restoration: Over the centuries, the temple has undergone several renovations and restorations to maintain its historical and religious significance. The stupa has been carefully preserved to ensure its structural integrity, and the temple complex has been maintained to provide a serene and peaceful environment for devotees.\n" +
                    "\n" +
                    "Tourist Attraction: Ruwanwelisaya Temple is not only a place of religious worship but also a popular tourist attraction. Visitors can explore the temple complex, admire the architectural beauty of the stupa, and learn about the rich cultural and religious heritage of Sri Lanka.\n" +
                    "\n" +
                    "Visiting Ruwanwelisaya Temple offers a unique opportunity to witness the ancient Buddhist architecture, experience the spiritual ambiance, and understand the deep-rooted Buddhist traditions of Sri Lanka. The temple stands as a symbol of faith, devotion, and historical significance in the country.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.350040648063482;
                double longitude = 80.3963681784171;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("sadahirusaya")) {
            head.setText("Sandahiru Seya");
            details.setText("Sandahiru Seya, vested with the Venerable Maha Sanga today was built to commemorate the heroic war heroes who made great sacrifices for the unity of the motherland and to mark the end of the Thirty Years War on a concept of the 5th Executive President and present Prime Minister Mahinda Rajapaksa and under the guidance of the then Defense Secretary President Gotabhaya Rajapaksa..\n" +
                    "\n" +
                    "Financial and labor donations were made by the Armed Forces, the Police, the Civil Defense Force, the clergy and laymen.\n" +
                    "\n" +
                    "This is the largest dagoba built in Sri Lanka after the construction of the Jethavanaramaya in Anuradhapura by King Mahasen in AD 301.\n" +
                    "\n" +
                    "Construction of “Sandahiru Seya Chaithya” commenced on 22 November 2010 and the sacred relics were placed on 22 November 2014. The ‘Crest Gem’ had been placed at the tip of the Stupa pinnacle on November 08, amidst religious observances.\n" +
                    "\n" +
                    "The stupa is 282 feet 6 inches high and 800 feet in circumference. This bubble shaped chaitya houses the sacred relics including the Kapilavastu relics. The height of the Crest Gem placed in the dagoba is 3 feet 6 inches. There are 1895 gemstones, inlaid with gold as well as pearls.\n" +
                    "\n" +
                    "The President and the Prime Minister unveiled the ‘Sacred Pinnacle’ and the ‘Crest-Gem’’ of Sandahiru Stupa amid Jaya Pirith chanting, Deva Aradhana, and the Hevisi drums. The Maha Sangha and the chief guests offered flowers and incense in front of the main Wahalkada statue and at the temple.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.338576700639132;
                double longitude = 80.39415183558225;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (res.equals("thuparamaya")) {
            head.setText("Thuparamaya Temple");
            details.setText("Thuparamaya Temple is an ancient Buddhist temple located in Anuradhapura, Sri Lanka. It is considered to be one of the holiest sites for Buddhists and holds great historical and religious significance. Here are some details about Thuparamaya Temple:\n" +
                    "\n" +
                    "Location: Thuparamaya Temple is situated in Anuradhapura, which was the capital of ancient Sri Lanka. It is located in the North Central Province of Sri Lanka, approximately 205 kilometers north of Colombo.\n" +
                    "\n" +
                    "Historical Significance: Thuparamaya Temple is believed to be the first stupa built in Sri Lanka after the introduction of Buddhism to the country. It was constructed during the reign of King Devanampiya Tissa (307–267 BC) to enshrine the right collarbone relic of Lord Buddha. The temple played a crucial role in the revival and spread of Buddhism in Sri Lanka.\n" +
                    "\n" +
                    "Stupa: The main feature of Thuparamaya Temple is the Thuparamaya Stupa, which is a circular-shaped structure that houses the sacred relics. It is considered one of the earliest and finest stupas in Sri Lanka. The stupa stands at a height of approximately 20 meters (65 feet) and has a circumference of about 59 meters (194 feet). It showcases the architectural styles of the Anuradhapura period.\n" +
                    "\n" +
                    "Architectural Beauty: Thuparamaya Stupa exhibits the architectural excellence of ancient Sri Lanka. The stupa is constructed with bricks and is adorned with intricate carvings and decorative elements. The pinnacle of the stupa is made of gold, giving it a majestic appearance.\n" +
                    "\n" +
                    "Buddhist Pilgrimage Site: Thuparamaya Temple is a significant pilgrimage site for Buddhists. Devotees visit the temple to pay homage, offer prayers, and seek blessings. It holds special importance during Buddhist festivals and full moon days when the temple is adorned with colorful decorations and illuminated with lights.\n" +
                    "\n" +
                    "Relic Chamber: Within the temple complex, there is a relic chamber that houses the sacred relics of Lord Buddha. This chamber is considered a sacred space and is a focal point for worship and meditation.\n" +
                    "\n" +
                    "Cultural Heritage: Thuparamaya Temple is not only a religious site but also a testament to the rich cultural heritage of Sri Lanka. It represents the early Buddhist architectural styles and serves as a reminder of the country's historical connections to Buddhism.\n" +
                    "\n" +
                    "Visiting Thuparamaya Temple allows visitors to immerse themselves in the spiritual ambiance, appreciate the ancient architecture, and gain insight into the profound influence of Buddhism on Sri Lankan culture and history.");

            maps.setOnClickListener(v -> {
                // Replace latitude and longitude with the desired location coordinates
                double latitude = 8.355373569765572;
                double longitude = 80.39647740594428;

                // Create a Uri with the desired location using the latitude and longitude
                String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

                // Create an intent with the ACTION_VIEW action and the Uri
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent1.setPackage("com.google.android.apps.maps"); // Optional: Specify the package to use Google Maps specifically

                // Verify if there is an activity available to handle the intent
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    // Start the activity with the intent
                    startActivity(intent1);
                } else {
                    // Handle the case where Google Maps is not installed
                    Toast.makeText(getApplicationContext(), "Google Maps is not installed", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }
}