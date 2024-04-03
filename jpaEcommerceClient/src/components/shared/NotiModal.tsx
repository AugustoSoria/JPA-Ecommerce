import { useState } from "react";
import './shared.css';

type Props = { msg: string, errorColor?: boolean }

function NotiModal({ msg, errorColor = false }: Props) {
    const [hidden, setHidden] = useState(false)
    if(!msg && errorColor) msg = "Something went wrong"

    return (
        <div className="noti-modal" style={{ display: hidden ? 'none' : 'flex' }}>
            <span className="noti-modal-bar" style={{backgroundColor: errorColor ? 'var(--red)' : 'var(--green)'}}></span>
            <p>{msg}</p>
            <div className="d-flex">
                <hr />
                <h5 onClick={() => setHidden(true)}>X</h5>
            </div>
        </div>
    );
}

export default NotiModal;