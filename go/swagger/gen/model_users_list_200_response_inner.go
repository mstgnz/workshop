/*
User API

An API for managing users

API version: 1.0.0
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"encoding/json"
)

// UsersList200ResponseInner struct for UsersList200ResponseInner
type UsersList200ResponseInner struct {
	Id *int32 `json:"id,omitempty"`
	Name *string `json:"name,omitempty"`
}

// NewUsersList200ResponseInner instantiates a new UsersList200ResponseInner object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewUsersList200ResponseInner() *UsersList200ResponseInner {
	this := UsersList200ResponseInner{}
	return &this
}

// NewUsersList200ResponseInnerWithDefaults instantiates a new UsersList200ResponseInner object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewUsersList200ResponseInnerWithDefaults() *UsersList200ResponseInner {
	this := UsersList200ResponseInner{}
	return &this
}

// GetId returns the Id field value if set, zero value otherwise.
func (o *UsersList200ResponseInner) GetId() int32 {
	if o == nil || o.Id == nil {
		var ret int32
		return ret
	}
	return *o.Id
}

// GetIdOk returns a tuple with the Id field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *UsersList200ResponseInner) GetIdOk() (*int32, bool) {
	if o == nil || o.Id == nil {
		return nil, false
	}
	return o.Id, true
}

// HasId returns a boolean if a field has been set.
func (o *UsersList200ResponseInner) HasId() bool {
	if o != nil && o.Id != nil {
		return true
	}

	return false
}

// SetId gets a reference to the given int32 and assigns it to the Id field.
func (o *UsersList200ResponseInner) SetId(v int32) {
	o.Id = &v
}

// GetName returns the Name field value if set, zero value otherwise.
func (o *UsersList200ResponseInner) GetName() string {
	if o == nil || o.Name == nil {
		var ret string
		return ret
	}
	return *o.Name
}

// GetNameOk returns a tuple with the Name field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *UsersList200ResponseInner) GetNameOk() (*string, bool) {
	if o == nil || o.Name == nil {
		return nil, false
	}
	return o.Name, true
}

// HasName returns a boolean if a field has been set.
func (o *UsersList200ResponseInner) HasName() bool {
	if o != nil && o.Name != nil {
		return true
	}

	return false
}

// SetName gets a reference to the given string and assigns it to the Name field.
func (o *UsersList200ResponseInner) SetName(v string) {
	o.Name = &v
}

func (o UsersList200ResponseInner) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]interface{}{}
	if o.Id != nil {
		toSerialize["id"] = o.Id
	}
	if o.Name != nil {
		toSerialize["name"] = o.Name
	}
	return json.Marshal(toSerialize)
}

type NullableUsersList200ResponseInner struct {
	value *UsersList200ResponseInner
	isSet bool
}

func (v NullableUsersList200ResponseInner) Get() *UsersList200ResponseInner {
	return v.value
}

func (v *NullableUsersList200ResponseInner) Set(val *UsersList200ResponseInner) {
	v.value = val
	v.isSet = true
}

func (v NullableUsersList200ResponseInner) IsSet() bool {
	return v.isSet
}

func (v *NullableUsersList200ResponseInner) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUsersList200ResponseInner(val *UsersList200ResponseInner) *NullableUsersList200ResponseInner {
	return &NullableUsersList200ResponseInner{value: val, isSet: true}
}

func (v NullableUsersList200ResponseInner) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUsersList200ResponseInner) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


