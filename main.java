import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
    	JPanel restart_panel = new JPanel(); 
    	JLabel textfield = new JLabel();
    	JButton[] buttons = new JButton[9];
    	JButton restartButton = new JButton("Restart"); 
	boolean player1_turn;
	boolean end;

	TicTacToe(){
		end=false;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
        	restartButton.setFont(new Font("Ink Free", Font.BOLD, 40));
        	restartButton.setFocusable(false);
       		restartButton.addActionListener(this);

        	restart_panel.setLayout(new BorderLayout());
        	restart_panel.add(restartButton, BorderLayout.CENTER);

		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		frame.add(restart_panel, BorderLayout.SOUTH);
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == restartButton) {
            		resetGame();
        	} else {
           	for (int i = 0; i < 9; i++) {
                   if (e.getSource() == buttons[i]) {
                    	if (player1_turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText("X");
                            player1_turn = false;
                            textfield.setText("O turn");
                            check();
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText("O");
                            player1_turn = true;
                            textfield.setText("X turn");
                            check();
                        }
                    }
                }
            }
        }	
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	
	public void check() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		else if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		else if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		else if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		else if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		else if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		else if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		else if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		else if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		else if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		else if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		else if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		else if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		else if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		else if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		else if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
		else{
			end=tie();
			}

	}
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		end=true;
		textfield.setText("X wins");
	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		end=true;
		textfield.setText("O wins");
	}
	public boolean tie() {
		for(int i=0;i<9;i++) {
			if(buttons[i].getText()=="") {
						return false;
					}
		}
		textfield.setText("Tie");
		return true;
	}
    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(new JButton().getBackground());
        }
        end = false;
        firstTurn();
    }
}
 class Main {

	public static void main(String[] args) {

		TicTacToe tictactoe = new TicTacToe();
		
	}
}

