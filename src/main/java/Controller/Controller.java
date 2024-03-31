package Controller;

import Model.Model;
import View.View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener
{
    private Model model;
    private View view;


    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.getPlayButton().addMouseListener(this);
        this.view.getTutorialButton().addMouseListener(this);
        this.view.getExitButton().addMouseListener(this);
        this.view.getBackButton().addMouseListener(this);
        this.view.getBackButton1().addMouseListener(this);
        this.view.getBackButton2().addMouseListener(this);
        this.view.getBackButton3().addMouseListener(this);
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                this.view.getGridButton(row, col).addMouseListener(this);
            }
        }
    }

        //events of buttons being clicked - handle interactions.
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 6; col++) {
                    if (e.getSource() == view.getGridButton(row, col)) {
                        //SET NEW DISPLAY

                        //AS LONG AS BUTTONS ARE ENABLED
                        if(this.view.getGridButton(row,col).isEnabled())
                        {
                            this.view.updateBoard(row, col, this.model.getNext());
                            this.model.systemFacts();
                            this.model.NextPlayerMove(row+1,col+1);
                            this.model.GameOver();
                            this.model.systemFacts();
                        }
                        this.view.getGridButton(row, col).setEnabled(false);

                        if(this.model.over==true)
                        {
                            handleOver();
                        }

                    } else if (e.getSource() == view.getPlayButton()) {
                        setBottomPanelVisible(false);
                        setGamePanelVisible(true);
                    } else if (e.getSource() == view.getTutorialButton()) {
                        setMechanicsPanelVisible(true);
                        setBottomPanelVisible(false);
                    } else if (e.getSource() == view.getExitButton()) {
                        System.exit(0);
                    } else if (e.getSource() == view.getBackButton()) {
                        setMechanicsPanelVisible(false);
                        setBottomPanelVisible(true);
                    }
                    else if(e.getSource()==view.getBackButton1())
                    {
                        System.exit(0);
                    }
                    else if(e.getSource()==view.getBackButton2())
                    {
                        System.exit(0);
                    }
                    else if(e.getSource()==view.getBackButton3())
                    {
                        System.exit(0);
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {/*UNUSED*/}

        @Override
        public void mouseReleased(MouseEvent e) {/*UNUSED*/}

        @Override
        public void mouseEntered(MouseEvent e) {/*UNUSED*/}

        @Override
        public void mouseExited(MouseEvent e) {/*UNUSED*/}
        //-----------------------------------------------------------

        //Methods for setting visibility-----------------------------
        public void setTopPanelVisible(boolean visible) {
            view.getTopPanel().setVisible(visible);
        }

        public void setBottomPanelVisible(boolean visible) {
            view.getBottomPanel().setVisible(visible);
        }

        public void setMechanicsPanelVisible(boolean visible) {
            view.getMechanicsPanel().setVisible(visible);
        }

        public void setGamePanelVisible(boolean visible) {
            view.getGamePanel().setVisible(visible);
        }
        public void setWinnerPanel1Visible(boolean visible) {
        view.getWinnerPanel1().setVisible(visible);
        }
        public void setWinnerPanel2Visible(boolean visible) {
        view.getWinnerPanel2().setVisible(visible);
        }
        public void setGameOverPanelVisible(boolean visible) {
            view.getGameOverPanel().setVisible(visible);
        }

    //-----------------------------------------------------------

        public void handleOver()
        {
            if(this.model.checkPlayerWin()==1)
            {
                setGamePanelVisible(false);
                setWinnerPanel1Visible(true);
            }
            else if(this.model.checkPlayerWin()==2)
            {
                setGamePanelVisible(false);
                setWinnerPanel2Visible(true);
            }
            else
            {
                setGamePanelVisible(false);
                setGameOverPanelVisible(true);
                System.out.println("Game Over !");
            }
        }
}
