import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class View extends JFrame {
    public int size = 10;
    public int numGames = 0;
    public int numWon = 0;
    public int numPercent =0;
    JLabel gamesWon;
    JLabel gamesPlayed;
    JLabel winPercentage;
    JButton[][] boardButtons;

    JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;

    public View(){
        super("MineSweeper Fun!");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //dimension will be adjustable upon opening of the program
        setPreferredSize(new Dimension(500,500));
        setupUI();
        pack();
    }

    private void setupUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        //Main game board grid panel of buttons
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(size,size));

        boardButtons = new JButton[10][10];
        for(int x = 0; x<size; x++){
            for (int y=0; y<size; y++){
                boardButtons[x][y] = new JButton(" ");
                boardButtons[x][y].setFont(new Font("Courier",Font.BOLD, 15));
                board.add(boardButtons[x][y]);
            }
        }

        panel.add(board, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3,2));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Session Stats"));

        JLabel GamesPlayed = new JLabel ("Games Played: ");
        statsPanel.add(GamesPlayed);

        gamesPlayed = new JLabel (" " + numGames);
        statsPanel.add(gamesPlayed);

        JLabel GamesWon = new JLabel("Games Won: ");
        statsPanel.add(GamesWon);

        gamesWon = new JLabel (" " + numWon);
        statsPanel.add(gamesWon);

        JLabel WinPercentage = new JLabel("Win Percentage: ");
        statsPanel.add(WinPercentage);

        winPercentage = new JLabel( " " + numPercent);
        statsPanel.add(winPercentage);


        topPanel.add(statsPanel, BorderLayout.EAST);
        panel.add(topPanel, BorderLayout.NORTH);
        //timer, bomb count, other options


        //Menu is not a panel but rather a drop down ~menu~

        getContentPane().add(panel);

        makeMenu();

    }

    private void makeMenu(){
        JMenuBar menuBar;
        JMenu menu;


        menuBar = new JMenuBar();

        menu = new JMenu("Menu ");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("The only menu with options");
        menuBar.add(menu);

        //group of JMenuItems
        menuItem1 = new JMenuItem("Preferences", KeyEvent.VK_P);
        // menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        // menuItem1.addActionListener(controller.new MyMenuActionListener1());
        menu.add(menuItem1);

        menuItem2 = new JMenuItem("Stats", KeyEvent.VK_S);
        //add action listener
        menu.add(menuItem2);

        menuItem3 = new JMenuItem("New Game", KeyEvent.VK_N);
        //add action listener
        menu.add(menuItem3);

//        menuItem4 = new JMenuItem("Reset Board", KeyEvent.VK_R);
//        menu.add(menuItem4);

        setJMenuBar(menuBar);
    }
}