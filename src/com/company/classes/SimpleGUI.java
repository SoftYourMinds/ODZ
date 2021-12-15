package com.company.classes;
import  java.awt.*;
import  java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class SimpleGUI extends JFrame {
    Controller controller = new Controller();
    Model model = new Model();
    View view = new View();

    private JLabel  headingLable = new JLabel("<html><span style ='font-size:20px;  font-weight: 500;'><font color = 'green'>Welcome to Cinder Books Shop</font></span></html>");
    private SpinnerNumberModel valueMin = new SpinnerNumberModel(2, 0, 11, 1);
    private JLabel findBooksLabel = new JLabel("<html><div style ='vertical-align: middle;'><span style ='font-size:14px; vertical-align: middle;'> Find books: </span></div></html>");
    private JLabel fromLabel = new JLabel("<html><span style='font-size: 10px'> from </span><html>");
    private SpinnerNumberModel valueMax = new SpinnerNumberModel(5, 0, 12, 1);
    private JSpinner minOldSpinner = new JSpinner(valueMin);
    private JLabel toMaxLabel = new JLabel("<html><span style='font-size: 10px'>to</span></html>" );
    private JSpinner maxOldSpinner = new JSpinner(valueMax);
    private JLabel lessThenLabel =  new JLabel("<html><span style='font-size: 10px'>less then</span></html>");
    private SpinnerNumberModel value = new SpinnerNumberModel(0,0.00, 100000.00, 0.01);
    private JSpinner lessJspinner = new JSpinner(value);
    private JButton findButton = new JButton("<html><span style='font-size: 10px; font-weight: 300;'>GO</span><html>");
    private JLabel changeMinBookLabel = new JLabel("<html><span style = 'font-size: 14px;'>Minimal coast book: </span></html>");
    private JLabel minCoastBook =  new JLabel("<html><span><font color: 'green'>"+controller.minCoastBook()+"</font></span></html>");

    private JButton back = new JButton("back");
    private JButton addBook = new JButton("Add book");
    private JButton editBook = new JButton("Edit book");
    private JButton searchBook =  new JButton("Search book");
    private JButton deleteBook = new JButton("Delete book");
    private JButton showAllBooks = new JButton("Show all books");

    private JPanel searchMenu =  new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel searchButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JLabel labelSearch = new JLabel("Search books");
    private JTextField textSearch = new JTextField("", 10);
    private JButton searches = new JButton("SEARCH");

    private JPanel addBookMenu =  new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel addBookInputs = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JLabel addingBookLable = new JLabel("Adding Book");
    private JLabel addNameLabelBook = new JLabel("Name");
    private JTextField addNameTextBook = new JTextField("", 10);
    private JLabel addCoastLabelBook = new JLabel("Coast");
    private SpinnerNumberModel addBookValue = new SpinnerNumberModel(0.00,0.00,11111111.00,0.01);
    private JSpinner addCoastBook = new JSpinner(addBookValue);
    private JLabel addNumberLabelBook = new JLabel("Average");
    private SpinnerNumberModel addNumberValue = new SpinnerNumberModel(0,0,30,1);
    private JSpinner addNumberBook = new JSpinner(addNumberValue);
    private JLabel addMinOldBooklLabel =new JLabel("Min old");
    private JLabel addMaxOldBooklLabel =new JLabel("Max old");
    private JSpinner addMinOldBook =  new JSpinner(valueMin);
    private JSpinner addMaxOldBook  = new JSpinner(valueMax);
    private JLabel empty = new JLabel("");
    private JButton addButtonBook = new JButton("ADD");
    private JPanel addBookGrid = new JPanel(new GridLayout(2,6,0,3));

    JPanel viewEdit = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JLabel editBookLabel = new JLabel("Edit book");
    private JButton editedBook = new JButton("EDIT");
    private JLabel editedBookOutput  = new JLabel("");
    private JButton searchEditButton = new JButton("FIND");

    private JPanel deleteMenu =  new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel deleteButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JLabel labelDelete = new JLabel("Delete books");
    private JTextField textDelete = new JTextField("", 10);
    private JButton deleats = new JButton("DELETE");

    public SimpleGUI() {
         super("CinderBookShop");
         this.setBounds(100, 100, 600, 300);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         GridLayout gridLayout = new GridLayout();
         gridLayout.setColumns(1);
         gridLayout.setRows(4);
         gridLayout.setHgap(4);
         gridLayout.setVgap(1);
         JPanel grid = new JPanel(gridLayout);

         JPanel flow1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
         JPanel flow2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
         JPanel menu =  new JPanel(new FlowLayout(FlowLayout.CENTER));
         JPanel flow3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            flow1.add(headingLable);
         grid.add(flow1);
            menu.add(searchBook);
            menu.add(showAllBooks);
            menu.add(addBook);
            menu.add(editBook);
            menu.add(deleteBook);
         grid.add(menu);
            flow2.add(findBooksLabel);
            flow2.add(fromLabel);
            minOldSpinner.addChangeListener(new changeMinMaxSizeSpinner());
            flow2.add(minOldSpinner);
            flow2.add(toMaxLabel);
            flow2.add(maxOldSpinner);
            flow2.add(lessThenLabel);
            flow2.add(lessJspinner);
            flow2.add(findButton);
            flow2.setVisible(true);
         grid.add(flow2);
            flow3.add(changeMinBookLabel);
            flow3.add(minCoastBook);
         grid.add(flow3);
         grid.setVisible(true);
         this.add(grid);

         this.findButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Object a = minOldSpinner.getValue();
                 Object b = maxOldSpinner.getValue();
                 Object c = lessJspinner.getValue();
                 System.out.println(Integer.parseInt(a.toString())+" " +Integer.parseInt(b.toString())+" "+ Double.valueOf(c.toString()));
                 String messege = controller.findBooks(Integer.parseInt(a.toString()), Integer.parseInt(b.toString()), Double.valueOf(c.toString()));
                 JOptionPane.showMessageDialog(null, messege, "Books", JOptionPane.PLAIN_MESSAGE);
             }
         });

        this.searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                searchMenu.add(labelSearch);
                searchMenu.add(back);
                searchButtons.add(textSearch);
                searchButtons.add(searches);

                grid.add(searchMenu);
                grid.add(searchButtons);

                menu.setVisible(false);
                flow2.setVisible(false);
                flow3.setVisible(false);
                gridLayout.setRows(6);
            }
        });

        searches.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textSearch.getText();
                JOptionPane.showMessageDialog(null, controller.findBook(text), "Books", JOptionPane.PLAIN_MESSAGE);
            }
        });

        this.searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                searchMenu.add(labelSearch);
                searchMenu.add(back);
                searchButtons.add(textSearch);
                searchButtons.add(searches);

                grid.add(searchMenu);
                grid.add(searchButtons);

                menu.setVisible(false);
                flow2.setVisible(false);
                flow3.setVisible(false);
                gridLayout.setRows(6);

            }
        });

        this.deleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                deleteMenu.add(labelDelete);
                deleteMenu.add(back);
                deleteButtons.add(textDelete);
                deleteButtons.add(deleats);

                grid.add(deleteMenu);
                grid.add(deleteButtons);

                menu.setVisible(false);
                flow2.setVisible(false);
                flow3.setVisible(false);
                gridLayout.setRows(6);
            }
        });

        deleats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textDelete.getText();
                JOptionPane.showMessageDialog(null, controller.deleleBook(text.toString()), "Deleted operation", JOptionPane.PLAIN_MESSAGE);
            }
        });

         back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 menu.setVisible(true);
                 flow2.setVisible(true);
                 flow3.setVisible(true);

                 grid.remove(searchMenu);
                 grid.remove(searchButtons);
                 grid.remove(addBookMenu);
                 grid.remove(addBookInputs);
                 grid.remove(viewEdit);
                 grid.remove(deleteMenu);
                 grid.remove(deleteButtons);
                 gridLayout.setRows(4);
                 gridLayout.setColumns(1);

                 String text =  controller.minCoastBook();
                 minCoastBook.setText(text);
                 setBounds(100, 100, 600, 300);

             }
         });

         showAllBooks.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String text ="";
                 String books = model.readDataBase();
                 if(books =="false"){
                     text = "<html><font color='red'>No anyone books in database!</font></html>";
                 }
                 else{
                     String[] book = books.split("/");
                     for(int i =0; i<book.length; i++){
                         text = text +view.viewBook(book[i])+"\n";
                     }

                 }
                    JOptionPane.showMessageDialog(null, text, "Books", JOptionPane.PLAIN_MESSAGE);

                 }
         });

         addBook.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                addBookGrid.add(addNameLabelBook);
                addBookGrid.add(addCoastLabelBook);
                addBookGrid.add(addNumberLabelBook);
                addMinOldBook.addChangeListener(new changeMinMaxSizeSpinner());
                addBookGrid.add(addMinOldBooklLabel);
                addBookGrid.add(addMaxOldBooklLabel);
                addBookGrid.add(empty);
                addBookGrid.add(addNameTextBook);
                addBookGrid.add(addCoastBook);
                addBookGrid.add(addNumberBook);
                addBookGrid.add(addMinOldBook);
                addBookGrid.add(addMaxOldBook);
                addBookGrid.add(addButtonBook);
                addBookGrid.remove(editedBook);

                 addBookMenu.add(addingBookLable);

                 addBookMenu.remove(editBookLabel);
                 addBookMenu.add(back);

                 addBookInputs.add(addBookGrid);

                 grid.add(addBookMenu);
                 grid.add(addBookInputs);

                 menu.setVisible(false);
                 flow2.setVisible(false);
                 flow3.setVisible(false);
                 gridLayout.setRows(6);
                 setBounds(100, 100, 800, 425);
             }
         });

        addButtonBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object name = addNameTextBook.getText();
                Object coast = addCoastBook.getValue();
                Object number = addNumberBook.getValue();
                Object minOld  = addMinOldBook.getValue();
                Object maxOld =  addMaxOldBook.getValue();
                String text = controller.addBook(name.toString(), Double.valueOf(coast.toString()), Integer.parseInt(number.toString()),Integer.parseInt(minOld.toString()), Integer.parseInt(maxOld.toString()));
                JOptionPane.showMessageDialog(null, text, "Books", JOptionPane.PLAIN_MESSAGE);
            }
        });

        editBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookGrid.add(addNameLabelBook);
                addBookGrid.add(addCoastLabelBook);
                addBookGrid.add(addNumberLabelBook);
                addMinOldBook.addChangeListener(new changeMinMaxSizeSpinner());
                addBookGrid.add(addMinOldBooklLabel);
                addBookGrid.add(addMaxOldBooklLabel);
                addBookGrid.add(empty);
                addBookGrid.add(addNameTextBook);
                addBookGrid.add(addCoastBook);
                addBookGrid.add(addNumberBook);
                addBookGrid.add(addMinOldBook);
                addBookGrid.add(addMaxOldBook);
                addBookGrid.add(editedBook);
                addBookGrid.remove(addButtonBook);

                addBookMenu.remove(addingBookLable);
                addBookMenu.add(editBookLabel);
                addBookMenu.add(back);


                viewEdit.add(textSearch);
                viewEdit.add(searchEditButton);
                viewEdit.add(editedBookOutput);


                addBookInputs.add(addBookGrid);


                grid.add(addBookMenu);
                grid.add(viewEdit);
                grid.add(addBookInputs);

                menu.setVisible(false);
                flow2.setVisible(false);
                flow3.setVisible(false);
                gridLayout.setRows(8);
                setBounds(100, 100, 814, 564);
            }

        });

        searchEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = textSearch.getText().toString();
                editedBookOutput.setText(controller.findBook(text));
            }
        });

        editedBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object lastName = textSearch.getText();
                Object name = addNameTextBook.getText();
                Object coast = addCoastBook.getValue();
                Object number = addNumberBook.getValue();
                Object minOld  = addMinOldBook.getValue();
                Object maxOld =  addMaxOldBook.getValue();
                String text = controller.editBook(lastName.toString(), name.toString(), Double.valueOf(coast.toString()), Integer.parseInt(number.toString()),Integer.parseInt(minOld.toString()), Integer.parseInt(maxOld.toString()));
                JOptionPane.showMessageDialog(null, text, "Books", JOptionPane.PLAIN_MESSAGE);
            }
        });


     }


    class changeMinMaxSizeSpinner implements ChangeListener{
        public void stateChanged(ChangeEvent e) {

            Object s = minOldSpinner.getValue();
            Object a = maxOldSpinner.getValue();
            valueMax.setMinimum(Integer.parseInt(s.toString()) +1);


            if(Integer.parseInt(s.toString()) == Integer.parseInt(a.toString())){
                maxOldSpinner.setValue(Integer.parseInt(s.toString()) +1);
            }

        }
    }

}
