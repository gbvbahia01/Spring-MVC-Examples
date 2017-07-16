/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bahia.guilherme.trade.util;

/**
 *
 * @author Guilherme
 */
public class DataTestShared {

    public static final String TYPE_SPOT = "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\","
            + "\"type\":\"Spot\",\"direction\":\"BUY\",\"tradeDate\":\"2016-08-11\","
            + "\"amount1\":1000000.00,\"amount2\":1120000.01,"
            + "\"rate\":1.17,\"valueDate\":\"2016-08-15\",\"legalEntity\":\"CS London\""
            + ",\"trader\":\"Johann Baumfiddler\"}";

    public static final String TYPE_FORWARD = "{\"customer\":\"JUPITER2\",\"ccyPair\":\"EURUSD\","
            + "\"type\":\"Forward\",\"direction\":\"SELL\",\"tradeDate\":\"2016-08-11\","
            + "\"amount1\":1000000.00,\"amount2\":1120909.99,\"rate\":1.17,"
            + "\"valueDate\":\"2016-08-22\",\"legalEntity\":\"CS London\","
            + "\"trader\":\"Johann Baumfiddler\"}";

    public static final String TYPE_OPTION = "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\","
            + "\"type\":\"VanillaOption\",\"style\":\"EUROPEAN\",\"direction\":\"BUY\""
            + ",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\","
            + "\"amount1\":1000000.00,\"amount2\":1120000.01,\"rate\":1.17,"
            + "\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-19\""
            + ",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\","
            + "\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\","
            + "\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"}";
    
    public static final String TYPE_OPTION_AMERICAN = "{\"customer\":\"JUPITER3\","
            + "\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"AMERICAN\","
            + "\"direction\":\"SELL\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\","
            + "\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,"
            + "\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-19\","
            + "\"excerciseDate\":\"2016-08-10\",\"payCcy\":\"USD\",\"premium\":0.20,"
            + "\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\","
            + "\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"}";

    public static final String TEST_DATA = "[\n"
            + "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"Spot\",\"direction\":\"BUY\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-15\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"Spot\",\"direction\":\"SELL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-22\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER2\",\"ccyPair\":\"EURUSD\",\"type\":\"Forward\",\"direction\":\"SELL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-22\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER2\",\"ccyPair\":\"EURUSD\",\"type\":\"Forward\",\"direction\":\"BUY\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-21\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER2\",\"ccyPair\":\"EURUSD\",\"type\":\"Forward\",\"direction\":\"BUY\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-08\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"PLUT02\",\"ccyPair\":\"EURUSD\",\"type\":\"Forward\",\"direction\":\"BUY\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-08\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER3\",\"ccyPair\":\"EURUSD\",\"type\":\"Forward\",\"direction\":\"BUY\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"valueDate\":\"2016-08-22\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"EUROPEAN\",\"direction\":\"BUY\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-19\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER2\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"EUROPEAN\",\"direction\":\"SELL\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-21\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"EUROPEAN\",\"direction\":\"BUY\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-25\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"AMERICAN\",\"direction\":\"BUY\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-19\",\"excerciseDate\":\"2016-08-12\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER2\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"AMERICAN\",\"direction\":\"SELL\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-21\",\"excerciseDate\":\"2016-08-12\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"AMERICAN\",\"direction\":\"BUY\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-25\",\"excerciseDate\":\"2016-08-12\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER1\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"AMERICAN\",\"direction\":\"BUY\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-19\",\"excerciseDate\":\"2016-08-10\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"},\n"
            + "{\"customer\":\"JUPITER3\",\"ccyPair\":\"EURUSD\",\"type\":\"VanillaOption\",\"style\":\"AMERICAN\",\"direction\":\"SELL\",\"strategy\":\"CALL\",\"tradeDate\":\"2016-08-11\",\"amount1\":1000000.00,\"amount2\":1120000.00,\"rate\":1.17,\"deliveryDate\":\"2016-08-22\",\"expiryDate\":\"2016-08-19\",\"excerciseDate\":\"2016-08-10\",\"payCcy\":\"USD\",\"premium\":0.20,\"premiumCcy\":\"USD\",\"premiumType\":\"%USD\",\"premiumDate\":\"2016-08-12\",\"legalEntity\":\"CS London\",\"trader\":\"Johann Baumfiddler\"}\n"
            + "]";
}
