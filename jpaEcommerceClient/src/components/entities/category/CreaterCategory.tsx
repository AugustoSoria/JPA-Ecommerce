import { useState } from "react";
import { categoryApi } from "../../../api/categoryApi";
import { Category } from "../../../model/Category";
import Spinner from "../../shared/Spinner";
import NotiModal from "../../shared/NotiModal";

function CreaterCategory() {
    const [successMsg, setSuccessMsg] = useState<string>()
    const [errorMsg, setErrorMsg] = useState<string>()
    const [loading, setLoading] = useState<boolean>()

    function create(event: React.ChangeEvent<HTMLFormElement>) {
        event.preventDefault()

        const newCategory: Category = {
            name: event.target.categoryName.value
        }

        setLoading(true)
        categoryApi.create(newCategory)
            .then((res) => setSuccessMsg(res))
            .catch((err: Error) => setErrorMsg(err.message))
            .finally(() => setLoading(false))

    }

    return (
        <section>
            <form className="create-form" onSubmit={create}>
                <label htmlFor="categoryName">name</label>
                <input type="text" name="categoryName" id="name" />
                <button type="submit">create</button>
            </form>
            {loading && <Spinner />}
            {successMsg && <NotiModal msg={successMsg} />}
            {errorMsg && <NotiModal msg={errorMsg} errorColor={true} />}
        </section>
    );
}

export default CreaterCategory;