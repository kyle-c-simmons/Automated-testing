import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Assert.*;
import static junit.framework.Assert.assertEquals;


public class StackSteps {

    private StackExample myStack;
    private Object pushed;
    private Object poped;

    @Given("^an empty stack$")
    public void an_empty_stack() {

    }

    @When("^I push an item into the stack$")
    public void i_push_an_item_into_the_stack(){
        pushed = new Object();
        myStack = new StackExample();
        myStack.push(pushed);

    }

    @Then("^the stack contains one item$")
    public void the_stack_contains_one_item() {
        myStack.size();

    }

    @When("^I push another item into the stack$")
    public void i_push_another_item_into_the_stack() {
        pushed = new Object();
        myStack.push(pushed);

    }

    @Then("^the stack contains two items$")
    public void the_stack_contains_two_items() {
        pushed = new Object();
        myStack.push(pushed);
        pushed = new Object();
        myStack.push(pushed);

    }

    @When("^I pop from the stack$")
    public void i_pop_from_the_stack() {
        Object out = myStack.pop();
        poped = out;
    }

    @Then("^I get the same item back$")
    public void i_get_the_same_item_back() {
        Assert.assertEquals(pushed, poped);
    }

    @Given("^a stack with one item in it$")
    public void a_stack_with_one_item_in_it() {

        pushed = new Object();
        myStack = new StackExample();
        myStack.push(pushed);

    }


    /*
    @Given("^an empty stack$")
    public void an_empty_stack() throws Throwable {
        Assert.assertEquals(0, myStack.size());
        throw new PendingException();
    }
    */


}
