import Model.Model;
import View.View;
import Controller.Controller;

public class Main
{
    public static void main(String[] args)
    {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
    }
}

/*6x6 Grid
* associated with view and associated with model
* whatever is in the model should be reflected in view
* tile 1 1 is occupied
* dapat occupied data is in the model
* put a piece on this tile dapat asa model
* model ang nagbabago, data is hihingiin ng controller and correspondingly update
* model = command line
*   get data, fetch by controller and update the view
*
*/