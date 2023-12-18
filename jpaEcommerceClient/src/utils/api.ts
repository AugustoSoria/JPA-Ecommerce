export async function handleCreateResponse(res: Response) {
    if(res.ok) return await res.text()
    const errorMsg = await res.text()
    throw new Error(errorMsg)
}

export async function handleResponse(res: Response) {
    if(res.ok) return res.json()
    const errorMsg = await res.text()
    throw new Error(errorMsg)
}

export const apiOptions: RequestInit = {
    method: "GET",
    headers: {
      'content-type': 'application/json'
    },
    body: null
}