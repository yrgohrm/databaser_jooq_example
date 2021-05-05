package se.yrgo.databaser;

import static se.yrgo.databaser.generated.Tables.HIGHSCORE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.yrgo.databaser.generated.tables.records.HighscoreRecord;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // Get rid of JOOQs quite annoying logo
        System.getProperties().setProperty("org.jooq.no-logo", "true");

        String userName = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        String host = System.getenv("DB_HOST");
        String url = String.format("jdbc:mysql://%s/hsdb", host);

        // We need to connect to the database ourselves using JDBC
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            // but then we hand over everything to JOOQ
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Result<HighscoreRecord> highscores = create.selectFrom(HIGHSCORE).fetch();
            for (HighscoreRecord hs : highscores) {
                int id = hs.getHighscoreId();
                int score = hs.getScore();
                String name = hs.getName();

                System.out.printf("id: %d, score: %5d, user: %s%n", id, score, name);
            }
        } catch (SQLException ex) {
            logger.error("Some lousy SQL went wrong.", ex);
        }
    }
}
