# passbook_merchants
Tech-stack:
IDEA + JDK1.8 + SpringBoot + Maven + Spring Data JPA + Mysql + Hbase + Redis + Kafka

Description:
The passbook application is consists of two parts Merchants and Client connected by Kafka. This application can gather and receive Coupons provided by Merchants.
Merchants: merchants register and authorized to provide Coupons.
Merchants should first apply for a token then use this token to make security authorization and registration. After registration merchants can start to distribute coupons, which should include title, limit, has token, start, and expiry date.
Client: store and receive the Coupons provided by merchants. passbook client can display all available and expired Coupons, all merchants put coupons and feedback function.
Keypoint:
1、Merchants info write to MySQL and gain a token for registration use spring interceptor for verification.
2、Coupon info writes to Kafka and ready for client to receive.
3、Use Redis to store the coupon's token info provided by merchants.
4、Create four tables in Hbase to store user's coupons, merchants dropped coupons, feedback, and user info.
5、Use Redis and a random number to generate a user ID.
6、Write coupons to base received from Merchants application
7、Redis used to store coupon token as a set and merchants as hashmap to avoid latency.
8、Use a log system to statistics and prevent hacking APIs.
9、Implement Restful APIs
