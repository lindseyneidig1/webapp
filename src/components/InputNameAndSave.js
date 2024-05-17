import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Toast from 'react-bootstrap/Toast';
import Container from 'react-bootstrap/Container';

function InputNameAndSave() {
    const [first_name, setFirstName] = useState('');
    const [middle_name, setMiddleName] = useState('');
    const [last_name, setLastName] = useState('');
    const [validated, setValidated] = useState(false);
    const [show, toggleShow] = useState(false);
    function setPosts() {}

    const handleSubmit = (event) => {
        const form = event.currentTarget;
        event.preventDefault();
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
            toggleShow(false)
        } else {
            addPosts(first_name, last_name);
            toggleShow(true)
        }

        setValidated(true);
    };

    const addPosts = async (first_name, last_name) => {
        await fetch('http://localhost:8080/person', {
            method: 'POST',
            body: JSON.stringify({
                first_name: first_name,
                middle_name: middle_name,
                last_name: last_name
            }),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'Accept': 'application/json',
                'Access-Control-Allow-Origin': '*'
            },
        })
            .then((response) => response.json())
            .then((data) => {
                setPosts((posts) => [data, ...posts]);
                setFirstName('');
                setMiddleName('');
                setLastName('');
            })
            .catch((err) => {
                console.log(err.message);
            });
    };

    const ToastSavedMessage = ({ children }) => {
        return (
            <>
                <Toast show={show} onClose={() => toggleShow(false)}>
                    <Toast.Header>
                        <strong className="mr-auto">Person Saved Successfully</strong>
                    </Toast.Header>
                    <Toast.Body>{children}</Toast.Body>
                </Toast>
            </>
        );
    };


    return (
        <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <h1 className="header">Welcome To Lindsey's App</h1>
            <Row className="mb-3">
                <Form.Group as={Col} md="4" controlId="validationCustom01">
                    <Form.Label>First name</Form.Label>
                    <Form.Control
                        required
                        type="text"
                        placeholder="First name"
                        onChange={(e) => setFirstName(e.target.value)}
                    />
                </Form.Group>
                <Form.Group as={Col} md="4" controlId="validationCustom02">
                    <Form.Label>Middle name</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Middle name"
                        onChange={(e) => setMiddleName(e.target.value)}
                    />
                </Form.Group>
                <Form.Group as={Col} md="4" controlId="validationCustom03">
                    <Form.Label>Last name</Form.Label>
                    <Form.Control
                        required
                        type="text"
                        placeholder="Last name"
                        onChange={(e) => setLastName(e.target.value)}
                    />
                </Form.Group>
            </Row>
            <Button type="submit">Submit form</Button>
            <Container className="p-3">
                <ToastSavedMessage>
                    Saved
                    <span role="img" aria-label="tada">
                      🎉
                    </span>
                </ToastSavedMessage>
            </Container>
        </Form>
    );
}

export default InputNameAndSave;