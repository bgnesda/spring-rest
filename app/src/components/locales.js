// src/components/contacts.js

import React from 'react'

const Locales = ({ locales }) => {
  return (
    <div>
      <center><h1>Locale List</h1></center>
      {locales.map(locale => (
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">{locale.name}</h5>
            <h6 class="card-subtitle mb-2 text-muted">{locale.code}</h6>
            <p class="card-text">{locale.isDefault.toString()}</p>
            <p class="card-text">{locale.isEnabled.toString()}</p>
          </div>
        </div>
      ))}
    </div>
  )
};

export default Locales