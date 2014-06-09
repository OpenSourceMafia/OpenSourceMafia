/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * - Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 
 * - Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * - Neither the name of Oracle or the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

// Oracle ButtonDemo modified by Stephen Hu
package InGame;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import Characters.TownCitizen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/*
 * CitizenAction.java requires the following files:
 * images/right.gif
 * images/left.gif
 */
public class CitizenAction extends JPanel implements ActionListener {
    protected JButton b1, b3;
    TownCitizen citizenToPerform;

    public CitizenAction(TownCitizen citizen) {
        citizenToPerform = citizen;
        ImageIcon leftButtonIcon = createImageIcon( "/images/right.gif" );
        ImageIcon rightButtonIcon = createImageIcon( "/images/left.gif" );

        b1 = new JButton( "Do not wear bulletproof vest.", rightButtonIcon );
        b1.setVerticalTextPosition( AbstractButton.CENTER );
        b1.setHorizontalTextPosition( AbstractButton.LEADING ); // aka LEFT, for
                                                                // left-to-right
                                                                // locales
        b1.setMnemonic( KeyEvent.VK_D );
        b1.setActionCommand( "notBulletproof" );

        b3 = new JButton( "Wear bulletproof vest (single use).", leftButtonIcon );
        // Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic( KeyEvent.VK_E );
        b3.setActionCommand( "isBulletproof" );

        // Listen for actions on buttons 1 and 3.
        b1.addActionListener( this );
        b3.addActionListener( this );

        b1.setToolTipText( "Click this button to not wear the bulletproof vest." );
        b3.setToolTipText( "Click this button to wear the bulletproof vest." );

        // Add Components to this container, using the default FlowLayout.
        add( b1 );
        add( b3 );
    }


    public void actionPerformed( ActionEvent e ) {
        if ( "isBulletproof".equals( e.getActionCommand() ) ) {
            //b1.setEnabled( true );
            //b3.setEnabled( false );


            if ( citizenToPerform.getActionAmmo() > 0 ) {
                citizenToPerform.setBulletproof( true );
                System.out.println( "You are bulletproof for tonight." );
                citizenToPerform.setActionAmmo( citizenToPerform.getActionAmmo() - 1 );

                System.out.println( "You have " + citizenToPerform.getActionAmmo() + " bulletproof vests left." );
            } else {
                citizenToPerform.setBulletproof( false );
                System.out.println( "No bulletproof vests are left." );
            }

            //System.exit( 0 );
        } else if ( "notBulletproof".equals( e.getActionCommand() ) ) {
            //b1.setEnabled( false );
            //b3.setEnabled( true );
            citizenToPerform.setBulletproof( false );
            System.out.println( "You have " + citizenToPerform.getActionAmmo() + " bulletproof vests left." );
            //System.exit( 0 );
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon( String path ) {
        java.net.URL imgURL = CitizenAction.class.getResource( path );
        if ( imgURL != null ) {
            return new ImageIcon( imgURL );
        } else {
            System.err.println( "Couldn't find file: " + path );
            return null;
        }
    }

    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI( TownCitizen citizen ) {

        // Create and set up the window.
        JFrame frame = new JFrame( "CitizenAction" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Create and set up the content pane.
        CitizenAction newContentPane = new CitizenAction( citizen );
        newContentPane.setOpaque( true ); // content panes must be opaque
        frame.setContentPane( newContentPane );

        // Display the window.
        frame.pack();
        frame.setVisible( true );
    }

    public void runAction() {
        System.out.println( citizenToPerform.getPlayerName() + ": Pick your wardrobe."  );
        createAndShowGUI( citizenToPerform );
    }
}