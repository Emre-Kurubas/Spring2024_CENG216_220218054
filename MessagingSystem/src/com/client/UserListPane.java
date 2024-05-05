package com.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class UserListPane extends JPanel implements UserStatusListener {

    private final ChatClient client;
    private JList<String> userListUI;
    private DefaultListModel<String> userListModel;

    public UserListPane(ChatClient client) {
        this.client = client;
        this.client.addUserStatusListener(this);

        userListModel = new DefaultListModel<>();
        userListUI = new JList<>(userListModel);
        userListUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userListUI.setBackground(new Color(240, 240, 240));
        userListUI.setFont(userListUI.getFont().deriveFont(Font.PLAIN, 18)); // Increase font size
        JScrollPane scrollPane = new JScrollPane(userListUI);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding
        scrollPane.setPreferredSize(new Dimension(250, 400)); // Set preferred size

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        userListUI.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    String login = userListUI.getSelectedValue();
                    MessagePane messagePane = new MessagePane(client, login);

                    JFrame f = new JFrame("Message: " + login);
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setSize(500, 500);

                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setBackground(Color.WHITE);
                    panel.add(messagePane, BorderLayout.CENTER);

                    f.getContentPane().add(panel);
                    f.setLocationRelativeTo(null); // Center the window
                    f.setVisible(true);
                }
            }
        });
    }

    @Override
    public void online(String login) {
        if (!userListModel.contains(login)) { // Check if the user is already in the list
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    userListModel.addElement(login);
                }
            });
        }
    }

    @Override
    public void offline(String login) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                userListModel.removeElement(login);
            }
        });
    }
}