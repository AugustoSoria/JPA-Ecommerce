import { categoryApi } from "../../api/categoryApi";
import { Category } from "../../model/Category";

function CreaterCategory() {

    function create(event: React.ChangeEvent<HTMLFormElement>) {
        event.preventDefault()

        const newCategory: Category = {
            name: event.target.categoryName.value
        }

        categoryApi.create(newCategory)
            .then(resp => resp.ok ? console.log("Category created") : console.log("Category not created"))

    }

    return (
        <section>
            <form className="create-form" onSubmit={create}>
                <label htmlFor="categoryName">name</label>
                <input type="text" name="categoryName" id="name" />
                <button type="submit">create</button>
            </form>
        </section>
    );
}

export default CreaterCategory;