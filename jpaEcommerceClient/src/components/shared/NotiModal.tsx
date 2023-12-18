import { useState } from "react";

type Props = { msg: string, errorColor?: boolean }

function NotiModal({ msg, errorColor = false }: Props) {
    const [hidden, setHidden] = useState(false)
    if(!msg && errorColor) msg = "Something went wrong"

    return (
        <div className="noti-modal" style={{color: errorColor ? 'red' : 'white', display: hidden ? 'none' : 'block' }}>
            <h5 onClick={() => setHidden(true)}>X</h5>
            <h4>{msg}</h4>
        </div>
    );
}

export default NotiModal;