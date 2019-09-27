package ru.job4j.track;

import org.apache.logging.log4j.LogManager;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection connection;

       public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Создает таблицу items, если она еще не создана.
     */
    private void createTable() throws Exception{
        Statement st = connection.createStatement();
        st.execute("create table if not exists items(" +
                "id serial primary key," +
                "name varchar(100)," +
                "description varchar(200)," +
                "time_of_creation bigint);");
    }

    public Item add(Item item) {
        try(PreparedStatement st = connection.prepareStatement(
                "insert into items (name, description, time_of_creation) values (?, ?, ?);"
        )) {
            st.setString(1, item.getName());
            st.setString(2, item.getDecs());
            st.setLong(3, item.getTime());
            st.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        try(PreparedStatement st = connection.prepareStatement(
                "update items set name = ?, description = ?, time_of_creation = ? where id = ?;"
        )) {
            st.setString(1, item.getName());
            st.setString(2, item.getDecs());
            st.setLong(3, item.getTime());
            st.setInt(4, Integer.parseInt(id));
            st.executeUpdate();
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        try(PreparedStatement st = connection.prepareStatement(
                "select * from items where id = ?;"
        )) {
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String desc = rs.getString("description");
                long time = rs.getLong("time_of_creation");
                result = new Item(name, desc, time);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        try(PreparedStatement st = connection.prepareStatement(
                "delete from items where id = ?;"
        )) {
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(
                    "select * from items;"
            );
            while(rs.next()) {
                String name = rs.getString("name");
                String desc = rs.getString("description");
                long time = rs.getLong("time_of_creation");
                result.add(new Item(name, desc, time));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(
                "select * from items where name = ?;"
        )) {
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String desc = rs.getString("description");
                long time = rs.getLong("time_of_creation");
                result.add(new Item(name, desc, time));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TrackerSQL testTracker = new TrackerSQL();
        testTracker.init();
    }
}
