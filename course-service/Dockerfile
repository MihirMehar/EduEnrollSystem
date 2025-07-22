# एक हल्के वजन वाले OpenJDK इमेज का उपयोग करें।
# Use a lightweight OpenJDK image.
FROM openjdk:17-jdk-slim

# इमेज के अंदर /app डायरेक्टरी बनाएं
# Create /app directory inside the image
WORKDIR /app  यहाँ पर 'course-service' की जगह '/app' रखें, यह एक सामान्य और अच्छा अभ्यास है।
             # Keep this as '/app' instead of 'course-service', it's a common and good practice.

# आपकी JAR फाइल को कंटेनर में कॉपी करें
# Copy your JAR file into the container
# अब JAR फाइल का पाथ 'target/' फोल्डर से दें
# Now provide the path to the JAR file from the 'target/' folder
COPY target/course-service-0.0.1-SNAPSHOT.jar app.jar

# जब कंटेनर शुरू होता है तो एप्लिकेशन चलाएं
# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]

# तुम्हारी एप्लिकेशन पोर्ट 8051 पर चल रही है, इसलिए इसे उजागर करें।
# Your application is running on port 8051, so expose it.
EXPOSE 8051