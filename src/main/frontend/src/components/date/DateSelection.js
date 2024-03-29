import React from 'react'

const DateSelection = () => {
    const [ date, setDate ] = useState('');
    const format = 'YYYY-MM-DD';

    const getSeperator = () => {
        const regex = /[^0-0a-zA-Z]+/;
    }


    const handleChangeDate = (e) => {
        const currentValue = e.target.value;
        setDate(currentValue);
    };

    return (
        <div>
            <input type='text' value={date} placeholder='placeholder' onChange={handleChangeDate}>
                <button type='button'>
                    
                </button>
            </input>
        </div>
    );
}

export default DateSelection;
