package com.yumcourt.repository;

import com.yumcourt.model.DeliveryExecutive;
import com.yumcourt.service.ConnectionService;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeliveryExecutiveRepository {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryExecutiveRepository.class);
    private Connection connection;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionService.getConnection();
        }
    }

    public List<DeliveryExecutive> retrieveDeliveryExecutives() {
        List<DeliveryExecutive> deliveryExecutives = new ArrayList<>();
        String query = "SELECT * FROM delivery_executive";

        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                long phoneNo = resultSet.getLong("phoneNo");
                boolean isAvailable = resultSet.getBoolean("is_available");

                DeliveryExecutive deliveryExecutive = new DeliveryExecutive(id, name, phoneNo, isAvailable);
                deliveryExecutives.add(deliveryExecutive);
            }
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
        return deliveryExecutives;
    }

    public void createDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        String query = "INSERT INTO delivery_executive (name, phoneNo, is_available) VALUES (?, ?, ?)";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, deliveryExecutive.getName());
            preparedStatement.setLong(2, deliveryExecutive.getPhoneNo());
            preparedStatement.setBoolean(3, deliveryExecutive.isAvailable());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
    }

    public void updateDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        String query = "UPDATE delivery_executive SET name = ?, phoneNo = ?, is_available = ? WHERE id = ?";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, deliveryExecutive.getName());
            preparedStatement.setLong(2, deliveryExecutive.getPhoneNo());
            preparedStatement.setBoolean(3, deliveryExecutive.isAvailable());
            preparedStatement.setLong(4, deliveryExecutive.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
    }

    public void deleteDeliveryExecutive(long id) {
        String query = "DELETE FROM delivery_executive WHERE id = ?";
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
    }

    public DeliveryExecutive findById(long id) {
        String query = "SELECT * FROM delivery_executive WHERE id = ?";
        DeliveryExecutive deliveryExecutive = null;
        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                long deliveryExecutiveId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                long phoneNo = resultSet.getLong("phoneNo");
                boolean isAvailable = resultSet.getBoolean("is_available");

                deliveryExecutive = new DeliveryExecutive(deliveryExecutiveId, name, phoneNo, isAvailable);
            }
        } catch (SQLException e) {
            logger.error("SQL error: {}", e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error closing connection: {}", e.getMessage(), e);
                }
            }
        }
        return deliveryExecutive;
    }
}
